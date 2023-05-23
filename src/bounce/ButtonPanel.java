package bounce;

import balls.BallCreationOperator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonPanel extends JPanel {

    private JLabel scoreLabel;
    private int score = 0;

    public ButtonPanel(BallCreationOperator ball,
                       BallCreationOperator redBlackOperator,
                       BallCreationOperator joinOperator) {

        super();

        scoreLabel = new JLabel("Score: 0");
        add(scoreLabel);

        setBackground(Color.lightGray);

        addBallCreationButton(1, ball);
        addBallCreationButton(10, ball);
        addBallCreationButton(100, ball);

        addRedBlackBallsButton(redBlackOperator);
        addJoinButton(joinOperator);

        addStopButton();
    }

    synchronized public void updateScore() {

        score += 1;
        scoreLabel.setText("Score: " + score);
    }

    private void addBallCreationButton(int newBallsAmount, BallCreationOperator ball) {

        JButton buttonAddBall = new JButton("Add ball");

        if (newBallsAmount > 1) {

            buttonAddBall.setText("Add " + newBallsAmount);
        }

        buttonAddBall.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                for (int i = 0; i < newBallsAmount; i++) {

                    ball.createBall();
                }
            }
        });

        add(buttonAddBall);
    }

    private void addRedBlackBallsButton(BallCreationOperator redBlackOperator) {

        JButton buttonStop = new JButton("Red black balls");

        buttonStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                redBlackOperator.createBall();
            }
        });

        add(buttonStop);
    }

    private void addJoinButton(BallCreationOperator joinOperator) {

        JButton buttonStop = new JButton("Join");

        buttonStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                joinOperator.createBall();
            }
        });

        add(buttonStop);
    }

    private void addStopButton() {

        JButton buttonStop = new JButton("Stop");

        buttonStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                System.exit(0);
            }
        });

        add(buttonStop);
    }
}
