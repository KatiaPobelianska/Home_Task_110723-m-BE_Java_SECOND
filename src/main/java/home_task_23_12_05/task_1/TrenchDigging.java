package home_task_23_12_05.task_1;

public class TrenchDigging {
    public static void main(String[] args) {
        Trench trench = new Trench(10);

        Worker worker1 = new Worker("Worker1", trench);
        Worker worker2 = new Worker("Worker2", trench);

        long startTime = System.currentTimeMillis();

        Thread thread1 = new Thread(worker1);
        Thread thread2 = new Thread(worker2);

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Trench digging of two workers: " + (endTime - startTime));
    }
}
