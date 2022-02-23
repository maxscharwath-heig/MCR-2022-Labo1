import javax.swing.*;
import java.awt.*;
import java.awt.geom.Point2D;

public abstract class Shape extends JComponent {
    private final int size;
    private Point2D position;
    private Vector2D velocity;

    public Shape(int size, Point2D position) {
        this.size = size;
        this.position = position;
        this.velocity = new Vector2D(Math.random() * 2 - 1, Math.random() * 2 - 1);
    }

    public void update() {
        position.setLocation(position.getX() + velocity.getX(), position.getY() + velocity.getY());
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
    }
}
