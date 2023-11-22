package home_task_23_11_21.config;

import home_task_23_11_21.enums.LogDestination;
import home_task_23_11_21.enums.LogLevel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class AppConfig {
    private LogLevel logLevel;
    private LogDestination logDestination;

    public AppConfig(String configFile) {
        loadConfig(configFile);
    }

    private void loadConfig(String configFile) {
        Properties properties = new Properties();
        try (FileInputStream input = new FileInputStream(configFile)) {
            properties.load(input);
            String logLevelStr = properties.getProperty("logLevel", "INFO");
            String logDestinationStr = properties.getProperty("logDestination", "CONSOLE");

            logLevel = LogLevel.valueOf(logLevelStr.toUpperCase());
            logDestination = LogDestination.valueOf(logDestinationStr.toUpperCase());
        } catch (IOException | IllegalArgumentException e) {
            e.printStackTrace();
            // В случае ошибки загрузки настроек, используем значения по умолчанию
            logLevel = LogLevel.INFO;
            logDestination = LogDestination.CONSOLE;
        }
    }

    public LogLevel getLogLevel() {
        return logLevel;
    }

    public LogDestination getLogDestination() {
        return logDestination;
    }
}

