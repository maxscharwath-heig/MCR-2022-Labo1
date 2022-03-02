import javax.swing.*;
import java.awt.*;

public class Window implements Displayer {

    private static Window instance;
    JFrame frame;

    private Window() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Board board = new Board();

        frame.setSize(1000, 800);

        frame.getContentPane().add(board, BorderLayout.CENTER);

        frame.setVisible(true);
        new Thread(board).start();
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
        return null;
    }

    @Override
    public void repaint() {

    }

    @Override
    public void setTitle(String title) {
        frame.setTitle(title);
    }
}
