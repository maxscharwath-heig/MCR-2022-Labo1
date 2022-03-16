import java.awt.*;
import java.util.LinkedList;

public class Bouncers {
    private LinkedList<Bouncable> bouncers;

    public Bouncers() {
        Window window = Window.getInstance();
        window.setTitle("Bouncers");
        int min = 5;
        int max = 30;
        for (int i = 0; i < 100; ++i) {
            //todo broken
            //bouncers.add(new AbstractSquare((int) (Math.random() * (max - min)) + min, new Vector2D(Math.random() * window.getWidth(), Math.random() * window.getHeight())));
            //bouncers.add(new AbstractCircle((int) (Math.random() * (max - min)) + min, new Vector2D(Math.random() * window.getWidth(), Math.random() * window.getHeight())));
        }
    }

    public static void main(String... args) {
        new Bouncers().run();
    }

    public void run() {
        new RenderThread(140).start();
        new UpdateThread(60).start();
    }

    private class RenderThread extends LoopedThread implements Renderer {
        RenderThread(int fps) {
            super(fps);
        }

        @Override
        protected void update() {
            var g = Window.getInstance().getGraphics();
            for (Bouncable bouncer : bouncers) {
                this.display(g, bouncer);
            }
        }

        @Override
        public void display(Graphics2D g, Bouncable b) {

        }
    }

    private class UpdateThread extends LoopedThread {
        UpdateThread(int fps) {
            super(fps);
        }

        @Override
        protected void update() {
            for (Bouncable shape : bouncers) {
                shape.move();
            }
        }
    }

}
