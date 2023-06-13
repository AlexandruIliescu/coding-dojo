package practice.multithreading.exercises;

/**
 * Create a program that simulates a ping-pong game using two threads.
 * One thread represents a player who sends "ping" and the other represents
 * a player who sends "pong". The players send messages to each other
 * a fixed number of times (e.g., 5 times each).
 * Ensure that the messages are printed in alternating order.
 */
class PingPong {
    private final Object lock = new Object();
    private final int maxTurns;
    private int turn = 1;

    public PingPong(int maxTurns) {
        this.maxTurns = maxTurns;
    }

    public void ping() {
        while (true) {
            synchronized (lock) {
                if (turn > maxTurns * 2) break;
                while (turn % 2 == 0) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("ping");
                turn++;
                lock.notifyAll();
            }
        }
    }

    public void pong() {
        while (true) {
            synchronized (lock) {
                if (turn > maxTurns * 2) break;
                while (turn % 2 != 0) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("pong");
                turn++;
                lock.notifyAll();
            }
        }
    }
}

class MainPingPong {
    public static void main(String[] args) {
        PingPong pingPong = new PingPong(5);
        Thread pingThread = new Thread(pingPong::ping);
        Thread pongThread = new Thread(pingPong::pong);
        pingThread.start();
        pongThread.start();
    }
}
