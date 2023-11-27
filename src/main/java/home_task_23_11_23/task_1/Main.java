package home_task_23_11_23.task_1;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import home_task_23_11_23.task_1.serviceResponse.ServiceResponse;

import javax.imageio.IIOException;
import java.io.File;
import java.io.IOException;

/* 1.Конвертировать данные из Json в объект:
 */
public class Main {
    public static void main(String[] args) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            ServiceResponse serviceResponse = objectMapper.readValue(new File("Example2.json"), ServiceResponse.class);

            System.out.println(serviceResponse);
        } catch (IIOException e){
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
