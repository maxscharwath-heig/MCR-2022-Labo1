package graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Image;
import java.awt.Dimension;
import java.awt.BorderLayout;
import java.awt.Graphics2D;
import java.awt.event.KeyAdapter;

/**
 * The Bouncers application main window
 *
 * @author Nicolas Crausaz
 * @author Maxime Scharwath
 */
public class Window implements Displayer {

    private final static int MIN_WIDTH = 500;
    private final static int MIN_HEIGHT = 500;
    private final static int INIT_WIDTH = 1000;
    private final static int INIT_HEIGHT = 800;

    private static Window instance;
    private final JFrame frame;
    private final JPanel panel;
    private Image image;

    private Window() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(MIN_WIDTH, MIN_HEIGHT));
        panel = new JPanel();
        frame.add(panel, BorderLayout.CENTER);
        frame.setSize(INIT_WIDTH, INIT_HEIGHT);
        frame.setVisible(true);
        image = createImage();
    }

    /**
     * Get the singleton instance of window
     * @return instance of window
     */
    public static Window getInstance() {
        if (instance == null) {
            instance = new Window();
        }
        return instance;
    }

    @Override
    public int getWidth() {
        return panel.getWidth();
    }

    @Override
    public int getHeight() {
        return panel.getHeight();
    }

    @Override
    public Graphics2D getGraphics() {
        return (Graphics2D) image.getGraphics();
    }

    @Override
    public void repaint() {
        panel.getGraphics().drawImage(image, 0, 0, null);
        image = createImage();
    }

    @Override
    public void setTitle(String title) {
        frame.setTitle(title);
    }

    @Override
    public void addKeyListener(KeyAdapter ka) {
        frame.addKeyListener(ka);
    }

    /**
     * Creates a drawable image that can be displayed in the displayer
     * @return new image
     */
    private Image createImage() {
        return frame.createImage(getWidth(), getHeight());
    }
}
