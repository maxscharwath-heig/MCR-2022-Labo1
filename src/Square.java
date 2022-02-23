import java.awt.*;
import java.awt.geom.Point2D;

public class Square extends Shape {

    private static final Color color = Color.YELLOW;

    public Square(int size, Point2D position) {
        super(size, position);
    }

    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect((int) position.getX(), (int) position.getY(), size, size);
    }
}
