import javax.swing.*;
import java.awt.*;

public class Window
{
    private Board board = new Board();

    public Window () {
        JFrame frame = new JFrame("Bouncers");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setPreferredSize(new Dimension(400, 300));

        frame.pack();

        frame.setVisible(true);
        new Thread(board).start();
    }
}
