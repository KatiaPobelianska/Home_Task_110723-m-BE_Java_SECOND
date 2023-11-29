package home_task_23_11_28.task_3.randomNumsExample;

import home_task_23_11_28.task_3.randomNumsGenerator.RandomNumsGenerator;

import java.util.Random;

public class RandomNumsExample {

    private final static Random RANDOM = new Random();

    public static void main(String[] args) {
        RandomNumsGenerator randomNumsGenerator = ((min, max) -> {
            if (min >= max) {
                throw new RuntimeException("Минимальное значение должно быть меньше максимального");
            }
            return RANDOM.nextInt(max + 1 - min) + min;
        });
        int randomN = randomNumsGenerator.generate(1, 120);

        System.out.println(randomN);

    }
}
