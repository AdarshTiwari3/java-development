package core_java.src.corejava.multithreading;


class PrintNumber {
    private int number = 1;
    private final int MAX_VALUE = 10;

    public synchronized void printOdd() {

        while (number <= MAX_VALUE) {
            while (number % 2 == 0 && number <= MAX_VALUE) {
                // event number, thread will wait here untill someone notifies
                try {
                    wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt(); // it can restart also
                }
            }
            if (number <= MAX_VALUE) {
                System.out.println("Odd:" + number);
                number++;
                notify(); // notifies the other thread to get resource access
            }

        }

    }

    public synchronized void printEven() { // here synchronized ensures only one thread will get
                                           // access of this method
        while (number <= MAX_VALUE) {
            while (number % 2 != 0 && number <= MAX_VALUE) {
                // odd number wait untill someone notifies
                try {
                    wait();

                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
            if (number <= MAX_VALUE) {
                System.out.println("Even:" + number);
                number++;
                notify();
            }

        }
    }

}


public class OddEvenThread {
    public static void main(String args[]) {

        PrintNumber printer = new PrintNumber();
        Thread t1 = new Thread(() -> printer.printOdd());
        Thread t2 = new Thread(() -> printer.printEven());

        t1.start();
        t2.start();



    }
}
