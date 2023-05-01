package bounce;

import balls.BallCreationOperator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonPanel extends JPanel {

    private JLabel scoreLabel;
    private int score = 0;

    public ButtonPanel(BallCreationOperator ball) {

        super();

        scoreLabel = new JLabel("Score: 0");
        add(scoreLabel);

        setBackground(Color.lightGray);

        addBallCreationButton(1, ball);
        addBallCreationButton(10, ball);
        addBallCreationButton(100, ball);

        addStopButton();
    }

    public void updateScore() {

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
