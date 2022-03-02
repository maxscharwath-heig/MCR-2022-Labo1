import java.awt.*;
import java.util.LinkedList;

public class Board implements Runnable {
    LinkedList<Shape> shapes;
    private boolean running = false;
    public Board() {
        shapes = new LinkedList<>();
        Window window = Window.getInstance();

        int min = 5;
        int max = 30;
        for (int i = 0; i < 100; ++i) {
            shapes.add(new Square((int) (Math.random() * (max - min)) + min, new Vector2D(Math.random() * window.getWidth(), Math.random() * window.getHeight())));
            shapes.add(new Circle((int) (Math.random() * (max - min)) + min, new Vector2D(Math.random() * window.getWidth(), Math.random() * window.getHeight())));
        }
    }

    public void update() {
        Window window = Window.getInstance();
        Vector2D bound = new Vector2D(window.getWidth(), window.getHeight());
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

    public void render(Graphics g) {
        for (Shape shape : shapes) {
            shape.draw(g);
        }
    }

    public void exit() {
        running = false;
    }

    public void run() {
        Window window = Window.getInstance();
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

                //render
                Image image = window.frame.createImage(window.getWidth(), window.getHeight());
                this.render(image.getGraphics());
                window.getGraphics().drawImage(image, 0, 0, null);

                delta--;
            }
        }
    }
}
