import java.awt.*;

public abstract class AbstractSquare extends AbstractShape {

    private static final Color color = Color.YELLOW;

    public AbstractSquare(int size, Vector2D position) {
        super(size, position);
    }

    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect((int) position.getX(), (int) position.getY(), size, size);
    }
}
