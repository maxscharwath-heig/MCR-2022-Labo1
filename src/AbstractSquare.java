import java.awt.*;

public abstract class AbstractSquare extends AbstractShape {

    public AbstractSquare(int size, Vector2D position) {
        super(size, position);
    }

    public void draw(Graphics g) {
        g.setColor(getColor());
        g.fillRect((int) position.getX(), (int) position.getY(), size, size);
    }

    @Override
    public void draw() {
        /*
        g.setColor(getColor());
        g.fillRect((int) position.getX(), (int) position.getY(), size, size);
         */
    }
}
