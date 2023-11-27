package home_task_23_11_23.task_2.address;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address implements Serializable {
    private String street;
    private String city;
}
