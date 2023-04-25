package balls;

public class BallMovementManager {

    private int holeX;
    private int holeY;
    private int holeSize;

    private Ball ball;
    private BallRemovingOperator removingOperator;

    public BallMovementManager(Ball ball, BallRemovingOperator removingOperator,
                               int holeX, int holeY, int holeSize) {

        this.ball = ball;
        this.removingOperator = removingOperator;

        this.holeX = holeX;
        this.holeY = holeY;
        this.holeSize = holeSize;
    }

    public boolean move() {

        ball.move();

        int dx = ball.getX() - (holeX + holeSize / 4);
        int dy = ball.getY() - (holeY + holeSize / 4);
        int distanceToHoleOperator = (int) Math.sqrt(dx * dx + dy * dy);

        if (distanceToHoleOperator < 30) {

            removingOperator.removeBall(ball);
            return false;
        }

        return true;
    }
}
