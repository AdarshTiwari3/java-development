package core_java.src.corejava.multithreading;

import static core_java.src.corejava.multithreading.ManualMultithreading.factorial;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorsFrameworkDemo {
    public static void main(String[] args) {
        // real multithreading with parallelism
        // we are continuing with same scenario of Manual Multithreading class
        ExecutorService executorService = Executors.newFixedThreadPool(10); // 10 threads pool
        long startTime = System.currentTimeMillis();
        for (int i = 1; i <= 10; i++) {
            int finalI = i;
            executorService.submit(() -> {
                long ans = factorial(finalI);
                System.out.printf("\nfactorial of %d=%d", finalI, ans);

            });
        }
        executorService.shutdown(); // No more tasks accepted
        try {
            // waiting to complete the running task
            executorService.awaitTermination(1, java.util.concurrent.TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("\nTime Taken to execute this(ms)="
                + (System.currentTimeMillis() - startTime) + "ms");



    }
}
