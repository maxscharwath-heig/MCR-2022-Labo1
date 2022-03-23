import factories.AbstractShapeFactory;
import factories.BorderedFactory;
import factories.FilledFactory;
import graphics.Bouncable;
import graphics.LoopedThread;
import graphics.Renderer;
import graphics.Window;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.geom.Point2D;
import java.util.ConcurrentModificationException;
import java.util.LinkedList;

public class Bouncers {
    private final LinkedList<Bouncable> bouncers = new LinkedList<>();

    public Bouncers() {
        Window window = Window.getInstance();
        window.setTitle("Bouncers");
        window.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_Q:
                        System.exit(0);
                        break;
                    case KeyEvent.VK_E:
                        bouncers.clear();
                        break;
                    case KeyEvent.VK_B:
                        addBouncers(new BorderedFactory(), 10);
                        break;
                    case KeyEvent.VK_F:
                        addBouncers(new FilledFactory(), 10);
                        break;
                }
            }
        });
        addBouncers(new FilledFactory(), 15);
    }

    public static void main(String... args) {
        new Bouncers().run();
    }

    private void addBouncers(AbstractShapeFactory factory, int count) {
        int min = 5;
        int max = 30;
        var window = Window.getInstance();
        for (int i = 0; i < count; ++i) {
            bouncers.add(factory.createCircle((int) (Math.random() * (max - min)) + min, new Point2D.Double((Math.random() * window.getWidth()), (Math.random() * window.getHeight()))));
            bouncers.add(factory.createSquare((int) (Math.random() * (max - min)) + min, new Point2D.Double((Math.random() * window.getWidth()), (Math.random() * window.getHeight()))));
        }
    }

    public void run() {
        new RenderThread(60).start();
        new UpdateThread(60).start();
    }

    private class RenderThread extends LoopedThread implements Renderer {
        RenderThread(int fps) {
            super(fps);
        }

        @Override
        protected void update() {
            var g = Window.getInstance().getGraphics();
            var it = bouncers.iterator();
            while (it.hasNext()) {
                try {
                    var b = it.next();
                    display(g, b);
                } catch (ConcurrentModificationException e) {
                    //Avoid ConcurrentModificationException
                    return;
                }
            }
            Window.getInstance().repaint();
        }

        @Override
        public void display(Graphics2D g, Bouncable b) {
            b.draw();
        }
    }

    private class UpdateThread extends LoopedThread {
        UpdateThread(int fps) {
            super(fps);
        }

        @Override
        protected void update() {
            var it = bouncers.iterator();
            while (it.hasNext()) {
                try {
                    var b = it.next();
                    b.move();
                } catch (ConcurrentModificationException e) {
                    //Avoid ConcurrentModificationException
                    return;
                }
            }
        }
    }

}
