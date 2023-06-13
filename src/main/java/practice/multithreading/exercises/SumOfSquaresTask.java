package practice.multithreading.exercises;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

class SumOfSquaresTask implements Runnable {

    private final int[] arr;
    private final int start;
    private final int end;
    private final AtomicLong result;

    public SumOfSquaresTask(int[] arr, int start, int end, AtomicLong result) {
        this.arr = arr;
        this.start = start;
        this.end = end;
        this.result = result;
    }

    @Override
    public void run() {
        long sum = 0;
        for (int i = start; i < end; i++) {
            sum += (long) arr[i] * arr[i];
        }
        result.addAndGet(sum);
    }
}

class MainThread {

    public static void main(String[] args) throws InterruptedException {
        int number = 100_000_000;
        int[] arr = new int[number];
        for (int i = 0; i < number; i++) {
            arr[i] = i;
        }

        // Single-threaded
        long startTime = System.currentTimeMillis();
        AtomicLong singleThreadResult = new AtomicLong();
        new SumOfSquaresTask(arr, 0, number, singleThreadResult).run();
        long endTime = System.currentTimeMillis();
        System.out.println("Single-threaded sum: " + singleThreadResult);
        System.out.println("Single-threaded time: " + (endTime - startTime) + " ms");

        // Multi-threaded with ExecutorService
        int threadCount = Runtime.getRuntime().availableProcessors();
        ExecutorService executor = Executors.newFixedThreadPool(threadCount);

        int partSize = number / threadCount;
        AtomicLong multiThreadResult = new AtomicLong();
        startTime = System.currentTimeMillis();
        for (int i = 0; i < threadCount; i++) {
            int start = i * partSize;
            int end = (i == threadCount - 1) ? number : start + partSize;
            executor.execute(new SumOfSquaresTask(arr, start, end, multiThreadResult));
        }

        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.MINUTES);
        endTime = System.currentTimeMillis();
        System.out.println("Multi-threaded sum: " + multiThreadResult);
        System.out.println("Multi-threaded time: " + (endTime - startTime) + " ms");
    }
}
