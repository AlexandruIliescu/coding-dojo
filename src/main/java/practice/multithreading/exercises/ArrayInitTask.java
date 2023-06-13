package practice.multithreading.exercises;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Create a program that initializes an array of size N
 * with the square of its index using multithreading.
 * Divide the array into equal parts and assign each part
 * to a separate thread.
 * Each thread initializes its assigned part of the array with the square of the index.
 */
class ArrayInitTask implements Runnable {
    private final int[] arr;
    private final int start;
    private final int end;

    public ArrayInitTask(int[] arr, int start, int end) {
        this.arr = arr;
        this.start = start;
        this.end = end;
    }

    @Override
    public void run() {
        for (int i = start; i < end; i++) {
            arr[i] = i * i;
        }
    }
}

class Main {
    public static void main(String[] args) throws InterruptedException {
        int N = 10;
        int[] arr = new int[N];
        int threadCount = 2;
        ExecutorService executor = Executors.newFixedThreadPool(threadCount);

        int partSize = N / threadCount;
        for (int i = 0; i < threadCount; i++) {
            int start = i * partSize;
            int end = (i == threadCount - 1) ? N : start + partSize;
            executor.execute(new ArrayInitTask(arr, start, end));
        }

        executor.shutdown();
        executor.awaitTermination(1, TimeUnit.MINUTES);

        for (int i = 0; i < N; i++) {
            System.out.println("arr[" + i + "] = " + arr[i]);
        }
    }
}
