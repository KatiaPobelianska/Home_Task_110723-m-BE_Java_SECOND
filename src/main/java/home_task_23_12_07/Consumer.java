package home_task_23_12_07;

import java.util.concurrent.TimeUnit;

public class Consumer implements Runnable{
    private final Storage storage;
    private final String consumerType;
    private final int consumerTime;

    public Consumer(Storage storage, String consumerType, int consumerTime) {
        this.storage = storage;
        this.consumerType = consumerType;
        this.consumerTime = consumerTime;
    }

    @Override
    public void run() {
        try {
            while (true) {
                storage.consume(consumerType);
                TimeUnit.MILLISECONDS.sleep(consumerTime);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
