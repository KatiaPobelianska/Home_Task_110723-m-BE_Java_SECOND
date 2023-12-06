package home_task_23_12_05.task_2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ParallelCalculationExample {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter value N: ");
        int N = sc.nextInt();

        System.out.println("Enter amount of threads: ");
        int numThreads = sc.nextInt();
        sc.close();

        List<Task> tasks = new ArrayList<>();
        List<Thread> threads = new ArrayList<>();

        int chunkSize = N / numThreads;

        for (int i = 0; i < numThreads; i++) {
            int start = i * chunkSize + 1;
            int end = (i == numThreads - 1) ? N : (i + 1) * chunkSize;

            Task task = new Task(start, end);
            tasks.add(task);

            Thread thread = new Thread(task);
            threads.add(thread);

            thread.start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        long totalResult = tasks.stream().mapToLong(Task::getResult).sum();

        System.out.println("Result:  " + totalResult);
    }
}

