package home_task_23_12_14.task_2;

import java.util.concurrent.ArrayBlockingQueue;

 class Consumer implements Runnable {
    private final ArrayBlockingQueue<Integer> storage;

    public Consumer(ArrayBlockingQueue<Integer> storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Integer value = storage.take();
                System.out.println("Consumed: " + value);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
