package home_task_23_11_23.task_1.serviceResponse;

import com.fasterxml.jackson.annotation.JsonProperty;
import home_task_23_11_23.task_1.supportContact.SupportContact;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ServiceResponse implements Serializable {
    @JsonProperty("serviceName")
    private String serviceName;
    @JsonProperty("code")
    private int code;
    @JsonProperty("userMessage")
    private String userMessage;
    @JsonProperty("isError")
    private boolean isError;
    @JsonProperty("supportContacts")
    private List<SupportContact> supportContacts;
}
