package home_task_23_11_28.task_1.digitsList;

import java.util.ArrayList;
import java.util.List;

/*1 Создайте список чисел. С помощью метода forEach выведите каждое число в консоль по модулю.*/
public class DigitsList {
    public static void main(String[] args) {
        List<Integer> digitsList = new ArrayList<>(5);
        digitsList.add(1);
        digitsList.add(2);
        digitsList.add(-3);
        digitsList.add(-4);
        digitsList.add(-5);

        digitsList.forEach(n -> System.out.println(Math.abs(n)));

    }
}
