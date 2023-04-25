package balls;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

public class BallCanvas extends JPanel {

    private ArrayList<Ball> balls = new ArrayList<>();
    private int holeX = 145;
    private int holeY = 170;
    private int holeSize = 60;

    public void add(Ball b) {
        balls.add(b);
    }

    public void remove(Ball b) {
        balls.remove(b);
    }

    public int getHoleX() {
        return holeX;
    }

    public int getHoleY() {
        return holeY;
    }

    public int getHoleSize() {
        return holeSize;
    }

    @Override
    public void paintComponent(Graphics g){

        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;
        g2.setColor(Color.darkGray);
        g2.fill(new Ellipse2D.Double(holeX, holeY, holeSize, holeSize));

        for (int i = 0; i < balls.size(); i++) {

            Ball b = balls.get(i);

            if (b != null) {

                b.draw(g2);
            }
        }
    }
}
