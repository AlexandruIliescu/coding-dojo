package practice.multithreading;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ExecutorExample {

    public static void main(String[] args) {
        Executor executor = Executors.newSingleThreadExecutor();
        Runnable task = () -> System.out.println("Task executed in single-threaded executor");
        executor.execute(task);
    }
}
