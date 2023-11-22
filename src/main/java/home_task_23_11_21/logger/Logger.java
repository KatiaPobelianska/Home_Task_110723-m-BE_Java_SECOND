package home_task_23_11_21.logger;

import home_task_23_11_21.enums.LogDestination;
import home_task_23_11_21.enums.LogLevel;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

public class Logger {
    private final LogLevel logLevel;
    private final LogDestination logDestination;

    public Logger(LogLevel logLevel, LogDestination logDestination) {
        this.logLevel = logLevel;
        this.logDestination = logDestination;
    }

    private void log(String message, LogLevel messageLevel) {
        if (messageLevel.ordinal() >= logLevel.ordinal()) {
            String logMessage = formatLogMessage(message, messageLevel);
            if (logDestination == LogDestination.CONSOLE) {
                System.out.println(logMessage);
            }
            if (logDestination == LogDestination.FILE) {
                writeToFile(logMessage);
            }
        }
    }

    private String formatLogMessage(String message, LogLevel messageLevel) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String formattedDate = dateFormat.format(new Date());
        return "[" + formattedDate + "]" + "[" + message + "]";
    }

    // Запись лога в файл
    private void writeToFile(String message) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("log.txt", true))) {
            writer.println(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void debug(String message) {
        log(message, LogLevel.DEBUG);
    }

    public void info(String message) {
        log(message, LogLevel.INFO);
    }

    public void warning(String message) {
        log(message, LogLevel.WARNING);
    }

    public void error(String message) {
        log(message, LogLevel.ERROR);
    }

    public static void logSystemProperties() {
        System.out.println("System Properties:");
        Map<String, String> env = System.getenv();
        for (String key : env.keySet()) {
            System.out.println(key + ": " + env.get(key));
        }
    }

}
