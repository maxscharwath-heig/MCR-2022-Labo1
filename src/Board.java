import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

public class Board extends JPanel implements Runnable {
    LinkedList<Shape> shapes;
    private boolean running = false;
    public Board() {
        setBackground(Color.WHITE);
        shapes = new LinkedList<>();

        int min = 5;
        int max = 30;
        for (int i = 0; i < 100; ++i) {
            shapes.add(new Square((int) (Math.random() * (max - min)) + min, new Vector2D(Math.random() * getWidth(), Math.random() * getHeight())));
            shapes.add(new Circle((int) (Math.random() * (max - min)) + min, new Vector2D(Math.random() * getWidth(), Math.random() * getHeight())));
        }
    }

    public void update() {
        Vector2D bound = new Vector2D(getWidth(), getHeight());
        for (Shape shape : shapes) {
            shape.getPosition().add(shape.getVelocity());
            Vector2D offset = shape.collisionOffset(bound);
            if(offset.getX() != 0) {
                shape.getVelocity().setX(-shape.getVelocity().getX());
                shape.getPosition().setX(shape.getPosition().getX() - offset.getX());
            }
            if(offset.getY() != 0) {
                shape.getVelocity().setY(-shape.getVelocity().getY());
                shape.getPosition().setY(shape.getPosition().getY() - offset.getY());
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
                repaint();
            }
        }
    }
}
