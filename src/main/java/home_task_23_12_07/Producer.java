package home_task_23_12_07;

import java.util.concurrent.TimeUnit;

public class Producer implements Runnable{
    private final Storage storage;
    private final String producerType;
    private final int producerTime;

    public Producer(Storage storage, String producerType, int producerTime) {
        this.storage = storage;
        this.producerType = producerType;
        this.producerTime = producerTime;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Resource resource = new Resource();
                storage.produce(resource, producerType);
                TimeUnit.MILLISECONDS.sleep(producerTime);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

}
