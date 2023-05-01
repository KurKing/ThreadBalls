package bounce;

import balls.*;

import javax.swing.*;
import java.awt.*;

public class BounceFrame extends JFrame {

    private BallCanvas canvas;
    private ButtonPanel buttonPanel;

    public static final int WIDTH = 450;
    public static final int HEIGHT = 350;

    public BounceFrame() {

        this.setSize(WIDTH, HEIGHT);
        this.setTitle("Bounce program");
        this.canvas = new BallCanvas();

        System.out.println("Create frame in thread #" + Thread.currentThread().getName());

        Container content = this.getContentPane();
        content.add(this.canvas, BorderLayout.CENTER);

        buttonPanel = new ButtonPanel(new BallCreationOperator() {
            @Override
            public void createBall() {

                Ball ball = new Ball(canvas);
                canvas.add(ball);

                BallRemovingOperator removingOperator = new BallRemovingOperator() {
                    @Override
                    public void removeBall(Ball ball) {

                        canvas.remove(ball);
                        buttonPanel.updateScore();
                    }
                };

                BallMovementManager manager = new BallMovementManager(ball,
                        removingOperator,
                        canvas.getHoleX(),
                        canvas.getHoleY(),
                        canvas.getHoleSize());

                BallThread thread = new BallThread(manager);

                thread.start();
            }
        });

        content.add(buttonPanel, BorderLayout.SOUTH);
    }
}
