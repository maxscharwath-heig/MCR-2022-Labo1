package shapes;

import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

public abstract class AbstractSquare extends AbstractShape {

    public AbstractSquare(int size, Point2D.Double position) {
        super(new Rectangle2D.Double(position.x, position.y, size, size));
    }

    @Override
    public void move() {
        Rectangle2D bounds = checkAndReactToCollision();
        ((Rectangle2D) this.getShape()).setFrame(bounds);
    }
}
