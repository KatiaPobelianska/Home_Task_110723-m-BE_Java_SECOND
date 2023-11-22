package home_task_23_11_21;

import home_task_23_11_21.config.AppConfig;
import home_task_23_11_21.logger.Logger;

public class Main {
    public static void main(String[] args) {
        // Создаем объект Logger с уровнем логирования и направлением из конфигурационного файла
        AppConfig appConfig = new AppConfig("config.properties");
        Logger logger = new Logger(appConfig.getLogLevel(), appConfig.getLogDestination());

        // Залогируем все параметры и переменные окружения
        Logger.logSystemProperties();

        // Вызываем все методы логирования
        logger.debug("This is a debug message");
        logger.info("This is an info message");
        logger.warning("This is a warning message");
        logger.error("This is an error message");
    }
}
