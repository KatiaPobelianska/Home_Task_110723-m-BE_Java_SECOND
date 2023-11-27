package home_task_23_11_23.task_2;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import home_task_23_11_23.task_2.address.Address;
import home_task_23_11_23.task_2.person.Person;

import javax.imageio.IIOException;
import java.io.File;
import java.io.IOException;

/* 2.Создать объект с 3-4 полями разных типов (в т.ч. ссылочных) и записать объект в файл в
виде Json.*/
public class Main {
    public static void main(String[] args) {
        Person person = new Person(
                "Kiwi Green",
                25,
                new Address("123 Main Str", "London")
        );
        // Сериализуем объект в формат JSON и записываем в файл
        ObjectMapper objectMapper = new ObjectMapper();
        ObjectWriter objectWriter = objectMapper.writerWithDefaultPrettyPrinter();// Добавляем форматирование JSON

        try {
            objectWriter.writeValue(new File("person.json"), person);
            System.out.println("Объект успешно записан в файл person.json");
        } catch (IOException e){
            e.printStackTrace();
        }


    }
}
