package home_task_23_11_23.task_2.person;

import home_task_23_11_23.task_2.address.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person implements Serializable {
    private String name;
    private int age;
    private Address address;
}
