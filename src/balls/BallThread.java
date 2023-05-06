package balls;

import java.util.Optional;

public class BallThread extends Thread {

    private BallMovementManager ballManager;
    private Optional<Thread> threadToJoin;

    public BallThread(BallMovementManager ballManager) {

        this.ballManager = ballManager;
        this.threadToJoin = Optional.empty();
    }

    public BallThread(BallMovementManager ballManager, Thread threadToJoin) {

        this.ballManager = ballManager;
        this.threadToJoin = Optional.of(threadToJoin);
    }

    @Override
    public void run() {

        try {

            while (!isInterrupted()) {

                System.out.println("Move in thread #" + Thread.currentThread().getName());

                if (threadToJoin.isPresent()) {

                    threadToJoin.get().join();
                }

                if (!ballManager.move()) { interrupt(); }
                Thread.sleep(5);
            }
        } catch(InterruptedException ex) {

            System.out.println("InterruptedException in thread #" + Thread.currentThread().getName());
        }
    }
}