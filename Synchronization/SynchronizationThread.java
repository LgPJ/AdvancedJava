package Synchronization;

public class SynchronizationThread extends Thread {

    static int n = 1;

    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(n);
            n++;
        }
    }

    public static void main(String args[]) {

        Thread thr1 = new SynchronizationThread();
        Thread thr2 = new SynchronizationThread();

        thr1.start();
        thr2.start();
    }
}
