package home_task_23_11_23.task_3.jsonPathExample;

import com.jayway.jsonpath.JsonPath;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/*3 Прочитать значение поля age из файла ниже с помощью JsonPath
https://mvnrepository.com/artifact/com.jayway.jsonpath/json-path
Вывести результат в консоль.*/
public class JsonPathExample {
    public static void main(String[] args) {
        try {
            // Читаем содержимое JSON-файла в строку
            String jsonContent = new String(Files.readAllBytes(Paths.get("person2.json")));

            // Используем JsonPath для извлечения значения поля age
            int age = JsonPath.read(jsonContent, "$.age");

            System.out.println("Значение поля age: " + age);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
