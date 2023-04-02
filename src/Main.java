import bounce.BounceFrame;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        BounceFrame frame = new BounceFrame();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        System.out.println("Start in thread #" + Thread.currentThread().getName());
    }
}