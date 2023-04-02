package bounce;

import balls.Ball;
import balls.BallCanvas;
import balls.BallThread;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BounceFrame extends JFrame {

    private BallCanvas canvas;
    public static final int WIDTH = 450;
    public static final int HEIGHT = 350;

    public BounceFrame() {

        this.setSize(WIDTH, HEIGHT);
        this.setTitle("Bounce programm");
        this.canvas = new BallCanvas();

        System.out.println("Create frame in thread #" + Thread.currentThread().getName());

        Container content = this.getContentPane();
        content.add(this.canvas, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.lightGray);

        JButton buttonAddBall = new JButton("Add ball");
        JButton buttonAdd10Balls = new JButton("Add 10 balls");
        JButton buttonAdd100Balls = new JButton("Add 100 balls");
        JButton buttonAdd1000Balls = new JButton("Add 1000 balls");

        JButton buttonStop = new JButton("Stop");

        buttonAddBall.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                    Ball ball = new Ball(canvas);
                    canvas.add(ball);
                    BallThread thread = new BallThread(ball);
                    thread.start();
                }
        });

        buttonAdd10Balls.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                for (int i = 0; i < 10; i++) {

                    Ball ball = new Ball(canvas);
                    canvas.add(ball);
                    BallThread thread = new BallThread(ball);
                    thread.start();
                }
            }
        });

        buttonAdd100Balls.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                for (int i = 0; i < 100; i++) {

                    Ball ball = new Ball(canvas);
                    canvas.add(ball);
                    BallThread thread = new BallThread(ball);
                    thread.start();
                }
            }
        });

        buttonAdd1000Balls.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                for (int i = 0; i < 1000; i++) {

                    Ball ball = new Ball(canvas);
                    canvas.add(ball);
                    BallThread thread = new BallThread(ball);
                    thread.start();
                }
            }
        });

        buttonStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                System.exit(0);
            }
        });

        buttonPanel.add(buttonAddBall);
        buttonPanel.add(buttonAdd10Balls);
        buttonPanel.add(buttonAdd100Balls);
        buttonPanel.add(buttonAdd1000Balls);
        buttonPanel.add(buttonStop);

        content.add(buttonPanel, BorderLayout.SOUTH);
    }
}
