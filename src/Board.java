import javax.swing.*;
import java.awt.*;
import java.awt.geom.Point2D;
import java.util.LinkedList;

public class Board extends JPanel {
    LinkedList<Shape> shapes;

    public Board () {
        shapes = new LinkedList<>();

        //for (int i = 0; i < 20; ++i) {
            shapes.add(new Square(10, new Point2D.Double(100, 100)));
        //}



        for (Shape shape : shapes)
        {
            add(shape);
            // shape.paint();
        }
        repaint();
    }

    public void paintComponent(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect (0, 0, 1000, 800);
    }
}
