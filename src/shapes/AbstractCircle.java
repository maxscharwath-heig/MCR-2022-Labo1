package shapes;

import utility.Vector2D;

import java.awt.*;

public abstract class AbstractCircle extends AbstractShape {

    public AbstractCircle(int size, Vector2D position) {
        super(size, position);
    }

    void draw(Graphics g) {
        g.setColor(getColor());
        g.fillOval((int) position.getX(), (int) position.getY(), size, size);
    }

    @Override
    public void draw() {

    }
}
