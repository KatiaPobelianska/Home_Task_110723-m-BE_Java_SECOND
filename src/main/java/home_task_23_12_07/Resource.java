package home_task_23_12_07;

public class Resource {
    private static int counter = 0;
    private final int id;

    public Resource() {
        synchronized (Resource.class) {
            id = counter++;
        }
    }

    public int getId() {
        return id;
    }
}
