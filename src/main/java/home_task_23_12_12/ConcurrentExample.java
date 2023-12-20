package home_task_23_12_12;
/*Дан список чисел из большого количества случайных чисел.
Используя синхронизированные коллекции, уберите из списка отрицательные значения.
Замерьте время выполнения метода в однопоточном режиме и в многопоточном.
3 Разработайте программу, использующую ConcurrentMap, для обеспечения безопасного
обновления значения по условию. Например, уменьшайте значение ключа "stock" на 1 только если
текущее значение больше 0.
*/
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.*;

public class ConcurrentExample {
    public static void main(String[] args) {
        // Генерация большого списка случайных чисел
        List<Integer> numbers = generateRandomNumbers(1_000_000);

        // Однопоточное удаление отрицательных значений
        long startTime = System.currentTimeMillis();
        List<Integer> resultSingleThreaded = removeNegativesSingleThreaded(numbers);
        long endTime = System.currentTimeMillis();
        System.out.println("Single-threaded execution time: " + (endTime - startTime) + " ms");

        // Многопоточное удаление отрицательных значений
        startTime = System.currentTimeMillis();
        List<Integer> resultMultiThreaded = removeNegativesMultiThreaded(numbers);
        endTime = System.currentTimeMillis();
        System.out.println("Multi-threaded execution time: " + (endTime - startTime) + " ms");

        // Проверка корректности результата
        assert resultSingleThreaded.equals(resultMultiThreaded);
    }

    // Генерация списка случайных чисел
    private static List<Integer> generateRandomNumbers(int size) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            numbers.add(ThreadLocalRandom.current().nextInt(-100, 100));
        }
        return numbers;
    }

    // Однопоточное удаление отрицательных значений
    private static List<Integer> removeNegativesSingleThreaded(List<Integer> numbers) {
        List<Integer> result = new ArrayList<>();
        for (Integer number : numbers) {
            if (number >= 0) {
                result.add(number);
            }
        }
        return result;
    }

    // Многопоточное удаление отрицательных значений
    private static List<Integer> removeNegativesMultiThreaded(List<Integer> numbers) {
        List<Integer> result = Collections.synchronizedList(new ArrayList<>());
        int numThreads = Runtime.getRuntime().availableProcessors();
        ExecutorService executorService = Executors.newFixedThreadPool(numThreads);

        // Разбиение списка на части для каждого потока
        List<List<Integer>> partitions = new ArrayList<>();
        int partitionSize = numbers.size() / numThreads;
        for (int i = 0; i < numThreads - 1; i++) {
            partitions.add(numbers.subList(i * partitionSize, (i + 1) * partitionSize));
        }
        partitions.add(numbers.subList((numThreads - 1) * partitionSize, numbers.size()));

        // Запуск потоков для обработки частей списка
        List<Future<List<Integer>>> futures = new ArrayList<>();
        for (List<Integer> partition : partitions) {
            futures.add(executorService.submit(() -> {
                List<Integer> partialResult = new ArrayList<>();
                for (Integer number : partition) {
                    if (number >= 0) {
                        partialResult.add(number);
                    }
                }
                return partialResult;
            }));
        }

        // Сбор результатов из потоков
        for (Future<List<Integer>> future : futures) {
            try {
                result.addAll(future.get());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        executorService.shutdown();
        return result;
    }
}
