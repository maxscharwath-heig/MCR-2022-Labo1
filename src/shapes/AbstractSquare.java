package shapes;

import graphics.Renderer;

import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

/**
 * A bouncing circle square
 *
 * @author Nicolas Crausaz
 * @author Maxime Scharwath
 */
public abstract class AbstractSquare extends AbstractShape {

    protected AbstractSquare(int size, Point2D.Double position, Renderer renderer) {
        super(new Rectangle2D.Double(position.x, position.y, size, size), renderer);
    }

    @Override
    public void move() {
        Rectangle2D bounds = checkAndReactToCollision();
        ((Rectangle2D) this.getShape()).setFrame(bounds);
    }
}
