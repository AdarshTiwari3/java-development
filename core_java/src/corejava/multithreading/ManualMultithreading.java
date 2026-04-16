package core_java.src.corejava.multithreading;

public class ManualMultithreading {
    public static void main(String[] args) {

        // currently this is single thread we will achieve multi threading here
        long startTime = System.currentTimeMillis();
        Thread[] threads = new Thread[10];
        for (int i = 1; i <= 10; i++) {
            int finalI = i;
            threads[i - 1] = new Thread(() -> {
                long ans = factorial(finalI);
                System.out.printf("\nfactorial of %d=%d", finalI, ans);
            });
            threads[i - 1].start(); // Manual thread creation and management


        }

        // Main thread waits for all worker threads to complete using join()

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();// Restore interrupt status so higher-level code
                // can handle interruption

            }
        }
        System.out.println("\nTime Taken to execute this(ms)="
                + (System.currentTimeMillis() - startTime) + "ms");

        // this is Multithreading, Concurrency, Parallelism

    }


    public static long factorial(int num) {

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        long res = 1;
        for (int i = 1; i <= num; i++) {
            res *= i;
        }
        return res;
    }
}
