package home_task_23_11_16.task_3.employee;

import java.io.*;

public class SerializationExample {
    public static void main(String[] args) {
        // Создаем объект сотрудника
        Employee employee1 = new Employee("John", "Doe", "1990-01-01", "Developer", 50000.0);

        // Сериализуем объект и сохраняем в файл
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("Employee.data"))){
            out.writeObject(employee1);
            System.out.println("Объект успешно сериализован и сохранен в файл.");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        // Десериализуем объект из файла
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream("Employee.data"))) {
            Employee deserializedEmployee = (Employee) in.readObject();
            System.out.println("Объект успешно десериализован:");
            System.out.println(deserializedEmployee);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
