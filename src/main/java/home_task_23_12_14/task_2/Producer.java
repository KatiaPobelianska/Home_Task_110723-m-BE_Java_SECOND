package home_task_23_12_14.task_2;

import java.util.concurrent.ArrayBlockingQueue;

 class Producer implements Runnable {
    private final ArrayBlockingQueue<Integer> storage;

    public Producer(ArrayBlockingQueue<Integer> storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= 20; i++) {
                storage.put(i);
                System.out.println("Produced: " + i);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
