package home_task_23_12_14.task_2;

import java.util.concurrent.ArrayBlockingQueue;

public class ProducerConsumerExample {
    private static final int CAPACITY = 10;

    public static void main(String[] args) {
        ArrayBlockingQueue<Integer> storage = new ArrayBlockingQueue<>(CAPACITY);

        Thread producer = new Thread(new Producer(storage));
        Thread consumer = new Thread(new Consumer(storage));

        producer.start();
        consumer.start();
    }
}
