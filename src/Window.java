import javax.swing.*;
import java.awt.*;

public class Window implements Displayer {

    private static Window instance;
    JFrame frame;

    private Window() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        frame.setSize(1000, 800);

        frame.setVisible(true);
    }

    public static Window getInstance() {
        if (instance == null) {
            instance = new Window();
        }
        return instance;
    }

    @Override
    public int getWidth() {
        return frame.getWidth();
    }

    @Override
    public int getHeight() {
        return frame.getHeight();
    }

    @Override
    public Graphics2D getGraphics() {
        return (Graphics2D) frame.getGraphics();
    }

    @Override
    public void repaint() {
        frame.repaint();
    }

    @Override
    public void setTitle(String title) {
        frame.setTitle(title);
    }
}
