import javax.swing.*;
import java.awt.*;

public class Window
{

    public Window (){
        JFrame frame = new JFrame("Bouncers");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(1000, 800);

        frame.setLayout(new BorderLayout());
        Board board = new Board();
        frame.add(board, BorderLayout.CENTER);

        frame.setVisible(true);
        new Thread(board).start();
    }
}
