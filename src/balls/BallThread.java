package balls;

import java.util.function.IntBinaryOperator;

public class BallThread extends Thread {

    private BallMovementManager ballManager;

    public BallThread(BallMovementManager ballManager) {

        this.ballManager = ballManager;
    }

    @Override
    public void run() {

        try {

            while (true) {

                System.out.println("Move in thread #" + Thread.currentThread().getName());

                if (!ballManager.move()) { interrupt(); }
                Thread.sleep(5);
            }
        } catch(InterruptedException ex) {}
    }
}