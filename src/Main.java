import bounce.BounceFrame;
import counter.Counter;
import counter.CounterThread;
import printing.PrintThread;

import javax.swing.*;
import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        BounceFrame frame = new BounceFrame();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        // TASK 5:
        System.out.println("Task 5");

        Semaphore semaphore1 = new Semaphore(1);
        Semaphore semaphore2 = new Semaphore(0);

        Thread printingThread1 = new PrintThread("-", true, semaphore1, semaphore2);
        Thread printingThread2 = new PrintThread("|", false, semaphore2, semaphore1);

        printingThread1.start();
        printingThread2.start();

        printingThread1.join();
        printingThread2.join();

        // TASK 6:
        System.out.println("\n\nTask 6");

        Counter counter = new Counter();
        Thread counterThread1 = new CounterThread(counter, true);
        Thread counterThread2 = new CounterThread(counter, false);

        counterThread1.start();
        counterThread2.start();

        counterThread1.join();
        counterThread2.join();

        System.out.println(counter.getCount());
    }
}