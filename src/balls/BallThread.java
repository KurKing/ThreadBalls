package balls;

public class BallThread extends Thread {

    private Ball b;

    public BallThread(Ball ball) {

        b = ball;
    }

    @Override
    public void run() {

        try {

            for (int i=1; i<10000; i++) {

                b.move();
                System.out.println("Move in thread #" + Thread.currentThread().getName());
                Thread.sleep(5);
            }
        } catch(InterruptedException ex) {

        }
    }
}