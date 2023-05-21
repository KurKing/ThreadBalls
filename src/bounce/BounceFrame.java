package bounce;

import balls.*;

import javax.swing.*;
import java.awt.*;

public class BounceFrame extends JFrame {

    private BallCanvas canvas;
    private ButtonPanel buttonPanel;

    public static final int WIDTH = 750;
    public static final int HEIGHT = 450;

    public BounceFrame() {

        this.setSize(WIDTH, HEIGHT);
        this.setTitle("Bounce program");
        this.canvas = new BallCanvas();

        Container content = this.getContentPane();
        content.add(this.canvas, BorderLayout.CENTER);

        BallRemovingOperator removingOperator = new BallRemovingOperator() {
            @Override
            public void removeBall(Ball ball) {
                canvas.remove(ball);
                buttonPanel.updateScore();
            }
        };

        BallRemovingOperator joinRemovingOperator = new BallRemovingOperator() {
            @Override
            public void removeBall(Ball ball) {
                canvas.remove(ball);
            }
        };

        buttonPanel = new ButtonPanel(creationOperator(removingOperator),
                redBlackBallsOperator(),
                joinBallOperator(joinRemovingOperator));

        content.add(buttonPanel, BorderLayout.SOUTH);
    }

    private BallCreationOperator creationOperator(BallRemovingOperator removingOperator) {

        return new BallCreationOperator() {
            @Override
            public void createBall() {

                Ball ball = new Ball(canvas);
                canvas.add(ball);

                BallMovementManager manager = new BallMovementManager(ball,
                        removingOperator,
                        canvas.getHoleX(),
                        canvas.getHoleY(),
                        canvas.getHoleSize(),
                        true);

                BallThread thread = new BallThread(manager);

                thread.start();
            }
        };
    }

    private BallCreationOperator redBlackBallsOperator() {

        return new BallCreationOperator() {
            @Override
            public void createBall() {

                for (int i = 0; i < 50; i++) {

                    createPriorityBall(Color.red, true);
                }

                for (int i = 0; i < 50; i++) {

                    createPriorityBall(Color.black, false);
                }
            }
        };
    }

    private void createPriorityBall(Color color, boolean isHighPriority) {

        Ball ball = new Ball(canvas, color);
        canvas.add(ball);

        BallMovementManager manager = new BallMovementManager(ball,
                new BallRemovingOperator() {
                    @Override
                    public void removeBall(Ball ball) {  }
                },
                canvas.getHoleX(),
                canvas.getHoleY(),
                canvas.getHoleSize(),
                false);

        BallThread thread = new BallThread(manager);

        if (isHighPriority) {

            thread.setPriority(Thread.MAX_PRIORITY);
        } else {

            thread.setPriority(Thread.MIN_PRIORITY);
        }

        thread.start();
    }

    private BallCreationOperator joinBallOperator(BallRemovingOperator removingOperator) {

        return new BallCreationOperator() {
            @Override
            public void createBall() {

                Ball ball = new Ball(canvas, Color.GREEN, 5, canvas.getHoleY()+10);
                canvas.add(ball);

                BallMovementManager manager = new BallMovementManager(ball,
                        removingOperator,
                        canvas.getHoleX(),
                        canvas.getHoleY(),
                        canvas.getHoleSize(),
                        true);

                BallThread thread = new BallThread(manager);

                thread.start();

                Ball ball2 = new Ball(canvas, Color.CYAN, 5, canvas.getHoleY()+10);
                canvas.add(ball2);

                BallMovementManager manager2 = new BallMovementManager(ball2,
                        removingOperator,
                        canvas.getHoleX(),
                        canvas.getHoleY(),
                        canvas.getHoleSize(),
                        true);

                BallThread thread2 = new BallThread(manager2, thread);

                thread2.start();
            }
        };
    }
}
