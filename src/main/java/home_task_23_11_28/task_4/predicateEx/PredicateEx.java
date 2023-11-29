package home_task_23_11_28.task_4.predicateEx;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/*4 Создайте предикат для удаления из списка тех строк, что начинаются с определённой буквы.
Создайте список строк и удалите элементы с помощью метода removeIf, передав в него предикат*/
public class PredicateEx {
    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();

        stringList.add("Kiwi");
        stringList.add("Ananas");
        stringList.add("Apples");
        stringList.add("Orange");
        stringList.add("Coffee");

        char startLetter = 'A';

        Predicate<String> startsWithLetter = s -> s.startsWith(String.valueOf(startLetter));
        stringList.removeIf(startsWithLetter);
        System.out.println("Список после удаления строк, начинающихся с буквы " + startLetter);
        stringList.forEach(System.out::println);
    }


}
