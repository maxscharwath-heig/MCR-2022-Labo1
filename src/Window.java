import javax.swing.*;
import java.awt.*;

public class Window {

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
}
