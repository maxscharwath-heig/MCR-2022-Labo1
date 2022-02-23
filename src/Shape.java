import javax.swing.*;
import java.awt.*;
import java.awt.geom.Point2D;

public abstract class Shape extends JComponent {
    private final int size;
    private Point2D position;

    public Shape(int size, Point2D position) {
        this.size = size;
        this.position = position;
    }
    // private xxx vector;

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}
