package home_task_23_12_05.task_2;

import java.util.Map;

/*2 Напишите программу, которая вычисляет какую-либо сложную функцию для каждого
целого числа от 1 до N, N – входной параметр (большое число, например, 10 000 000)
N – ввод с консоли. Результат выводится на экран. Поскольку N – большое, необходимо
разбить вычисления на несколько частей и каждую часть вычислить в отдельном потоке
параллельно. Для каждой части нужно создать объект Task, внутри которого запомнить
данные для начала вычислений, а так же сохранить результат после завершения
вычислений. Каждый поток работает со своим объектом Task.
*/
public class Task implements Runnable{
    private final int start;
    private final int end;
    private long result;

    public Task(int start, int finish) {
        this.start = start;
        this.end = finish;
        this.result = 0;
    }

    public long getResult() {
        return result;
    }

    @Override
    public void run() {
        for (int i = start; i < end; i++) {
            result += i * i;
        }


    }
}
