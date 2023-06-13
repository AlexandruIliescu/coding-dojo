package practice.multithreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceExample {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Runnable task1 = () -> System.out.println("Task 1 executed in fixed thread pool");
        Runnable task2 = () -> System.out.println("Task 2 executed in fixed thread pool");

        executorService.execute(task1);
        executorService.execute(task2);
        executorService.shutdown();
    }
}
