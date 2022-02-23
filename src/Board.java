import javax.swing.*;
import java.awt.*;
import java.awt.geom.Point2D;
import java.util.LinkedList;

public class Board extends JPanel implements Runnable  {
    LinkedList<Shape> shapes;

    public Board () {
        setBackground(Color.WHITE);

        shapes = new LinkedList<>();

        // int rand = (int)(Math.random() * range) + min;
        int tmpPos = 100;

        for (int i = 0; i < 200; ++i) {
            shapes.add(new Square((int)(Math.random() * (20 - 10 + 10) + 1), new Point2D.Double(tmpPos, tmpPos)));
            shapes.add(new Circle((int)(Math.random() * (20 - 10 + 10) + 1), new Point2D.Double(tmpPos, tmpPos)));
            tmpPos += 50;
        }

        System.out.println(shapes.size());

        repaint();
    }

    public void update() {
        for (Shape shape : shapes) {
            shape.update();
        }
        repaint();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Shape shape : shapes)
        {
            shape.draw(g);
        }
    }

    public void run() {
        final double delay = 1000000000.0 / 60.0; // 60 fps
        long lastTime = System.nanoTime();
        double delta = 0;
        while (true) {
            long now = System.nanoTime();
            delta += (now - lastTime) / delay;
            lastTime = now;
            while (delta >= 1) {
                this.update();
                delta--;
            }
        }
    }
}
