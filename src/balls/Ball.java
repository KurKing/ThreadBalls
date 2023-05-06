package balls;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.Random;

public class Ball {

    private Component canvas;
    private Color color;
    private int x;
    private int y;

    private static final int SIZE = 20;

    private int dx = 2;
    private int dy = 2;

    // Init for join
    public Ball(Component c, Color color, int x, int y) {

        canvas = c;
        this.color = color;

        this.x = x;
        this.y = y;
        dy = 0;
    }

    // Init for red black
    public Ball(Component c, Color color) {

        canvas = c;
        this.color = color;

        x = 10;
        y = 10;
    }

    public Ball(Component c) {

        canvas = c;
        color = ballColor();

        x = (int) (new Random().nextInt(this.canvas.getWidth()) * Math.random());
        y = (int) (new Random().nextInt(this.canvas.getHeight()) * Math.random());
    }

    public void draw (Graphics2D g2) {

        g2.setColor(color);
        g2.fill(new Ellipse2D.Double(x,y,SIZE,SIZE));
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void move(){

        x += dx;
        y += dy;

        if (x < 0) {

            x = 0;
            dx = -dx;
        }

        if (x + SIZE >= this.canvas.getWidth()) {

            x = this.canvas.getWidth() - SIZE;
            dx = -dx;
        }

        if (y < 0) {

            y = 0;
            dy = -dy;
        }

        if (y + SIZE >= this.canvas.getHeight()) {

            y = this.canvas.getHeight() - SIZE;
            dy = -dy;
        }

        this.canvas.repaint();
    }

    private Color ballColor() {

        Random random = new Random();
        int randomNumber = random.nextInt(3);

        switch (randomNumber) {
            case 0:
                return Color.blue;
            case 1:
                return Color.magenta;
            default:
                return Color.orange;
        }
    }
}
