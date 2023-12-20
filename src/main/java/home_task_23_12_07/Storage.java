package home_task_23_12_07;

import java.util.LinkedList;
import java.util.Queue;

public class Storage {

    private final int storageSize;
    private final Queue<Resource> resources = new LinkedList<>();

    public Storage(int storageSize) {
        this.storageSize = storageSize;
    }

    public synchronized void produce(Resource resource, String producerType) throws InterruptedException {
        while (resources.size() >= storageSize) {
            System.out.println("Storage is full. " + producerType + " " + Thread.currentThread().getId() + " is waiting.");
            wait();
        }

        resources.add(resource);
        System.out.println(System.currentTimeMillis() + ": " + producerType + " " + Thread.currentThread().getId() +
                " produced resource " + resource.getId() + ". Current storage size: " + resources.size());

        notifyAll();
    }

    public synchronized void consume(String consumerType) throws InterruptedException {
        while (resources.isEmpty()) {
            System.out.println("Storage is empty. " + consumerType + " " + Thread.currentThread().getId() + " is waiting.");
            wait();
        }

        Resource resource = resources.poll();
        System.out.println(System.currentTimeMillis() + ": " + consumerType + " " + Thread.currentThread().getId() +
                " consumed resource " + resource.getId() + ". Current storage size: " + resources.size());

        notifyAll();
    }
}
