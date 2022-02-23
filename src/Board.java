import java.util.LinkedList;

public class Board implements Runnable {
    LinkedList<Shape> shapes;

    public Board() {
        shapes = new LinkedList<>();
    }

    public void update() {
        System.out.println("update");
        for (Shape shape : shapes) {
            shape.update();
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
