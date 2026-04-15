package core_java.src.corejava.multithreading;

public class ExecuterFrameworkDemo {
    public static void main(String[] args) {

        // currently this is single thread we will achieve multi threading here
        long startTime = System.currentTimeMillis();
        for (int i = 1; i <= 10; i++) {
            long ans = factorial(i);
            System.out.printf("\nfactorial of %d=%d", i, ans);
        }
        System.out.println("\nTime Taken to execute this(ms)="
                + (System.currentTimeMillis() - startTime) + "ms");

    }

    private static long factorial(int num) {

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
