import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

public class Board extends JPanel implements Runnable {
    LinkedList<Shape> shapes;
    private boolean running = false;
    public Board() {
        setBackground(Color.WHITE);

        shapes = new LinkedList<>();

        // int rand = (int)(Math.random() * range) + min;
        int min = 5;
        int max = 30;
        for (int i = 0; i < 100; ++i) {
            shapes.add(new Square((int) (Math.random() * (max - min)) + min, new Vector2D(Math.random() * getWidth(), Math.random() * getHeight())));
            shapes.add(new Circle((int) (Math.random() * (max - min)) + min, new Vector2D(Math.random() * getWidth(), Math.random() * getHeight())));
        }
    }

    public void update() {
        for (Shape shape : shapes) {
            shape.position.add(shape.velocity);
            if (shape.position.getX() > getWidth()) {
                shape.velocity.setX(-shape.velocity.getX());
                shape.position.setX(getWidth());
            }
            if (shape.position.getX() < 0) {
                shape.velocity.setX(-shape.velocity.getX());
                shape.position.setX(0);
            }
            if (shape.position.getY() > getHeight()) {
                shape.velocity.setY(-shape.velocity.getY());
                shape.position.setY(getHeight());
            }
            if (shape.position.getY() < 0) {
                shape.velocity.setY(-shape.velocity.getY());
                shape.position.setY(0);
            }
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Shape shape : shapes) {
            shape.draw(g);
        }
    }

    public void exit() {
        running = false;
    }

    public void run() {
        running = true;
        final double delay = 1000000000.0 / 60.0; // 60 fps
        long lastTime = System.nanoTime();
        double delta = 0;
        while (running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / delay;
            lastTime = now;
            while (delta >= 1) {
                this.update();
                delta--;
            }
            repaint();
        }
    }
}
