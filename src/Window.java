import javax.swing.*;
import java.awt.*;

public class Window implements Displayer {

    private static Window instance;

    private Window() {
        JFrame frame = new JFrame("Bouncers");
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
        return 0;
    }

    @Override
    public int getHeight() {
        return 0;
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

    }
}
