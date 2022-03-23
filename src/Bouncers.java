import factories.AbstractShapeFactory;
import factories.BorderedFactory;
import factories.FilledFactory;
import graphics.Bouncable;
import graphics.LoopedThread;
import graphics.Window;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.geom.Point2D;
import java.util.concurrent.LinkedBlockingQueue;

public class Bouncers {
    private final LinkedBlockingQueue<Bouncable> bouncers = new LinkedBlockingQueue<>();

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
        //RenderThread
        new LoopedThread(60){
            @Override
            protected void update() {
                for (Bouncable b : bouncers) {
                    b.draw();
                }
                Window.getInstance().repaint();
            }
        }.start();

        //Update Thread
        new LoopedThread(60){
            @Override
            protected void update() {
                for (Bouncable b : bouncers) {
                    b.move();
                }
            }
        }.start();
    }
}
