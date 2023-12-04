package home_task_23_11_30.tasks_1_2_3_4;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Room {
    private double area;

    public void increaseArea() {
        this.area *= 1.3;
    }
}
