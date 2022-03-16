import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;

public class Window implements Displayer {

    private static Window instance;
    public final JFrame frame;
    private final JPanel panel;
    private Image image;

    private Window() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(500, 500));
        panel = new JPanel();
        frame.add(panel, BorderLayout.CENTER);
        frame.setSize(1000, 800);
        frame.setVisible(true);
        image = createImage();
    }

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

    private Image createImage() {
        return frame.createImage(getWidth(), getHeight());
    }
}
