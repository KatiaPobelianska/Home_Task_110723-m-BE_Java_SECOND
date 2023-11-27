package home_task_23_11_23.task_1.supportContact;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SupportContact implements Serializable {
    @JsonProperty("id")
    private int id;
    @JsonProperty("phone")
    private String phone;
    @JsonProperty("email")
    private String email;
}
