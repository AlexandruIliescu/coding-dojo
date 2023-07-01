package practice.clean_code;

public class DIP {
}

interface Logger {
    void log(String message);
}

class FileLogger implements Logger {
    @Override
    public void log(String message) {
        // Logic to log message to a file
    }
}

class ConsoleLogger implements Logger {
    @Override
    public void log(String message) {
        // Logic to log message to the console
    }
}

class LoggerService {
    private Logger logger;

    public LoggerService(Logger logger) {
        this.logger = logger;
    }

    public void performLogging(String message) {
        logger.log(message);
    }
}

// Client code example
class ExampleClientDip {
    public static void main(String[] args) {
        Logger fileLogger = new FileLogger();
        LoggerService fileLoggerService = new LoggerService(fileLogger);
        fileLoggerService.performLogging("Logging to file...");

        Logger consoleLogger = new ConsoleLogger();
        LoggerService consoleLoggerService = new LoggerService(consoleLogger);
        consoleLoggerService.performLogging("Logging to console...");
    }
}

