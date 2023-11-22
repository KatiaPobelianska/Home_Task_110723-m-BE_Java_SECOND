package home_task_23_11_16.task_3.employee;

import java.io.Serial;
import java.io.Serializable;

/*Создайте класс Сотрудник с полями имя, фамилия, дата рождения, должность,
заработная плата. Сериализуйте объект и сохраните в файл. Поле заработной платы
сериализовать не нужно, т.к. это коммерческая тайна организации.
*/
public class Employee implements Serializable {
    @Serial
    private static final long serialVersionUID = 2764L;

    public Employee(String firstName, String lastName, String birthDay, String position, double salary) {
    }
}
