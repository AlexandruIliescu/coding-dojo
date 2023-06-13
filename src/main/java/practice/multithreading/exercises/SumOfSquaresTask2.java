package practice.multithreading.exercises;

import java.util.concurrent.*;

class SumOfSquaresTask2 implements Callable<Long> {
    private final int[] arr;
    private final int start;
    private final int end;

    public SumOfSquaresTask2(int[] arr, int start, int end) {
        this.arr = arr;
        this.start = start;
        this.end = end;
    }

    @Override
    public Long call() {
        long sum = 0;
        for (int i = start; i < end; i++) {
            sum += (long) arr[i] * arr[i];
        }
        return sum;
    }
}

class MainSumOfSquares {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        int number = 100_000_000;
        int[] arr = new int[number];
        for (int i = 0; i < number; i++) {
            arr[i] = i;
        }

        // Single-threaded
        long startTime = System.currentTimeMillis();
        long singleThreadSum = new SumOfSquaresTask2(arr, 0, number).call();
        long endTime = System.currentTimeMillis();
        System.out.println("Single-threaded sum: " + singleThreadSum);
        System.out.println("Single-threaded time: " + (endTime - startTime) + " ms");

        // Multi-threaded with ExecutorService
        int threadCount = Runtime.getRuntime().availableProcessors();
        ExecutorService executor = Executors.newFixedThreadPool(threadCount);

        int partSize = number / threadCount;
        Future<Long>[] futures = new Future[threadCount];
        startTime = System.currentTimeMillis();
        for (int i = 0; i < threadCount; i++) {
            int start = i * partSize;
            int end = (i == threadCount - 1) ? number : start + partSize;
            futures[i] = executor.submit(new SumOfSquaresTask2(arr, start, end));
        }

        long multiThreadSum = 0;
        for (Future<Long> future : futures) {
            multiThreadSum += future.get();
        }

        endTime = System.currentTimeMillis();
        executor.shutdown();
        System.out.println("Multi-threaded sum: " + multiThreadSum);
        System.out.println("Multi-threaded time: " + (endTime - startTime) + " ms");
    }
}
