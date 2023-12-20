package home_task_23_12_07;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ProductionConsumptionExample {
    public static void main(String[] args)  {
        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream("config.properties"));

            int producerCount = Integer.parseInt(properties.getProperty("producerCount", "1"));
            int consumerCount = Integer.parseInt(properties.getProperty("consumerCount", "1"));
            int producerTime = Integer.parseInt(properties.getProperty("producerTime", "1000"));
            int consumerTime = Integer.parseInt(properties.getProperty("consumerTime", "1000"));
            int storageSize = Integer.parseInt(properties.getProperty("storageSize", "10"));

            Storage storage = new Storage(storageSize);

            for (int i = 0; i < producerCount; i++) {
                Thread producerThread = new Thread(new Producer(storage, "Producer", producerTime));
                producerThread.start();
            }

            for (int i = 0; i < consumerCount; i++) {
                Thread consumerThread = new Thread(new Consumer(storage, "Consumer", consumerTime));
                consumerThread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
