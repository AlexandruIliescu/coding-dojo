package practice.multithreading.exercises;


/**
 * Create a program that prints even and odd numbers
 * from 1 to N using two threads: one for even numbers
 * and the other for odd numbers.
 * Use synchronization to ensure that the numbers
 * are printed in the correct order.
 */
class NumberPrinter {
    private int currentNumber = 1;
    private int maxNumber;

    public NumberPrinter(int maxNumber) {
        this.maxNumber = maxNumber;
    }

    public synchronized void printEven() {
        while (currentNumber <= maxNumber) {
            while (currentNumber % 2 != 0) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Even: " + currentNumber);
            currentNumber++;
            notify();
        }
    }

    public synchronized void printOdd() {
        while (currentNumber <= maxNumber) {
            while (currentNumber % 2 == 0) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Odd: " + currentNumber);
            currentNumber++;
            notify();
        }
    }
}

class MainNumberPrinter {
    public static void main(String[] args) {
        NumberPrinter numberPrinter = new NumberPrinter(10);
        Thread evenThread = new Thread(numberPrinter::printEven);
        Thread oddThread = new Thread(numberPrinter::printOdd);
        evenThread.start();
        oddThread.start();
    }
}
