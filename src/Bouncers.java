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

    private final static int EXIT_KEY_CODE = KeyEvent.VK_Q;
    private final static int CLEAR_KEY_CODE = KeyEvent.VK_E;
    private final static int ADD_FILL_KEY_CODE = KeyEvent.VK_F;
    private final static int ADD_BORDER_KEY_CODE = KeyEvent.VK_B;
    private final static int NUM_TO_ADD = 10;
    private final static int MIN_SHAPE_DIAMETER = 5;
    private final static int MAX_SHAPE_DIAMETER = 30;

    private final LinkedBlockingQueue<Bouncable> bouncers = new LinkedBlockingQueue<>();

    public Bouncers() {
        Window window = Window.getInstance();
        window.setTitle("Bouncers");
        window.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case EXIT_KEY_CODE:
                        System.exit(0);
                        break;
                    case CLEAR_KEY_CODE:
                        bouncers.clear();
                        break;
                    case ADD_BORDER_KEY_CODE:
                        addBouncers(new BorderedFactory(), NUM_TO_ADD);
                        break;
                    case ADD_FILL_KEY_CODE:
                        addBouncers(new FilledFactory(), NUM_TO_ADD);
                        break;
                }
            }
        });
    }

    public static void main(String... args) {
        new Bouncers().run();
    }

    /**
     * Add new bouncers to the simulation
     * @param factory factory to use for shapes creation
     * @param count number of shapes to create
     */
    private void addBouncers(AbstractShapeFactory factory, int count) {
        var window = Window.getInstance();
        for (int i = 0; i < count; ++i) {
            bouncers.add(factory.createCircle(
                    (int) (Math.random() * (MAX_SHAPE_DIAMETER - MIN_SHAPE_DIAMETER)) + MIN_SHAPE_DIAMETER,
                    new Point2D.Double((Math.random() * window.getWidth()), (Math.random() * window.getHeight())))
            );

            bouncers.add(factory.createSquare(
                    (int) (Math.random() * (MAX_SHAPE_DIAMETER - MIN_SHAPE_DIAMETER)) + MIN_SHAPE_DIAMETER,
                    new Point2D.Double((Math.random() * window.getWidth()), (Math.random() * window.getHeight())))
            );
        }
    }

    /**
     * Run two thread, one for moving shapes, one for render.
     */
    public void run() {
        // RenderThread
        new LoopedThread(60) {
            @Override
            protected void update() {
                for (Bouncable b : bouncers) {
                    b.draw();
                }
                Window.getInstance().repaint();
            }
        }.start();

        // Update Thread
        new LoopedThread(60) {
            @Override
            protected void update() {
                for (Bouncable b : bouncers) {
                    b.move();
                }
            }
        }.start();
    }
}
