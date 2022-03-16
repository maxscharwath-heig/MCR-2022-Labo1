import java.awt.*;

public abstract class AbstractCircle extends AbstractShape {

    private static final Color color = Color.BLUE;

    public AbstractCircle(int size, Vector2D position) {
        super(size, position);
    }

    void draw(Graphics g) {
        g.setColor(color);
        g.fillOval((int) position.getX(), (int) position.getY(), size, size);
    }
}
