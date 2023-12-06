package home_task_23_12_05.task_1;

public class Worker implements Runnable{
    private final String name;
    private final Trench trench;

    public Worker(String name, Trench trench) {
        this.name = name;
        this.trench = trench;
    }

    @Override
    public void run() {
        while (trench.getCurrentLength() < trench.getTargetLength()){
            trench.dig(1);
            System.out.println("Current length: " +trench.getCurrentLength()+ " " + name + " dug 1 meter");

            try {
                Thread.sleep(5000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        System.out.println(name + " finished to dig. Total time: " + System.currentTimeMillis());
    }
}
