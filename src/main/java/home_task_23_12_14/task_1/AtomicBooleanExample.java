package home_task_23_12_14.task_1;



import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicBoolean;

/* Создайте 10 потоков, каждый из которых «делает вычисления»
(генерирует случайное число, ждёт сгенерированное число миллисекунд, добавляет
сгенерированное число в общую для всех потоков переменную). Используя AtomicBoolean,
создайте флаг, указывающий на возможность завершения приложения.
Когда потоки накопят в общей переменной число 1000000 флаг становится true.*/

public class AtomicBooleanExample {

    private static final int THREAD_COUNT = 10;
    private static final int TARGET_COUNT = 1000000;

    private static final AtomicBoolean terminationFlag = new AtomicBoolean(false);
    private static volatile int sharedVariable = 0;

    public static void main(String[] args) {
        Thread[] threads = new Thread[THREAD_COUNT];

        // Создание и запуск потоков
        for (int i = 0; i < THREAD_COUNT; i++) {
            threads[i] = new Thread(new Worker());
            threads[i].start();
        }

        // Ожидание достижения целевого значения
        while (sharedVariable < TARGET_COUNT) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Установка флага для завершения потоков
        terminationFlag.set(true);

        // Ожидание завершения всех потоков
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("All threads have finished. Shared variable: " + sharedVariable);
    }

    static class Worker implements Runnable {
        @Override
        public void run() {
            while (!terminationFlag.get()) {
                int randomValue = ThreadLocalRandom.current().nextInt(1, 100);
                try {
                    Thread.sleep(randomValue);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                // Добавление сгенерированного числа в общую переменную
                sharedVariable += randomValue;

                // Проверка условия завершения
                if (sharedVariable >= TARGET_COUNT) {
                    terminationFlag.set(true);
                    break;
                }
            }
        }
    }
}