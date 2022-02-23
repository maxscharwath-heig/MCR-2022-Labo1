import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

public class Board extends JPanel implements Runnable  {
    LinkedList<Shape> shapes;

    public Board () {
        shapes = new LinkedList<>();

        //for (int i = 0; i < 20; ++i) {
            shapes.add(new Square(10, new Point2D.Double(100, 100)));
        //}



        for (Shape shape : shapes)
        {
            add(shape);
            // shape.paint();
        }
        repaint();
    }

    public void paintComponent(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect (0, 0, 1000, 800);
    }

    public void update() {
        System.out.println("update");
        for (Shape shape : shapes) {
            // shape.update();
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
