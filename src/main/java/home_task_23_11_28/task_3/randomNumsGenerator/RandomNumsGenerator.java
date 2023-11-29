package home_task_23_11_28.task_3.randomNumsGenerator;
/*3 Создайте функциональный интерфейс для генерации случайных чисел в заданном диапазоне.
Используйте лямбда-выражение для генерации числа.*/
@FunctionalInterface
public interface RandomNumsGenerator {
    int generate(int min, int max);
}
