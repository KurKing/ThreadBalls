package bounce;

import balls.BallCreationOperator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonPanelBuilder {

    public static JPanel build(BallCreationOperator ball) {

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

                ball.createBall();
            }
        });

        buttonAdd10Balls.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                for (int i = 0; i < 10; i++) {

                    ball.createBall();
                }
            }
        });

        buttonAdd100Balls.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                for (int i = 0; i < 100; i++) {

                    ball.createBall();
                }
            }
        });

        buttonAdd1000Balls.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                for (int i = 0; i < 1000; i++) {

                    ball.createBall();
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

        return buttonPanel;
    }
}
