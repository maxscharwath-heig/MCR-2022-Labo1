package shapes;

import graphics.Renderer;

import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

/**
 * A bouncing circle shape
 *
 * @author Nicolas Crausaz
 * @author Maxime Scharwath
 */
public abstract class AbstractCircle extends AbstractShape {

    protected AbstractCircle(int size, Point2D.Double position, Renderer renderer) {
        super(new Ellipse2D.Double(position.x, position.y, size, size), renderer);
    }

    @Override
    public Ellipse2D getShape() {
        return (Ellipse2D) super.getShape();
    }

    @Override
    public void move() {
        Rectangle2D bounds = checkAndReactToCollision();
        this.getShape().setFrame(bounds);
    }
}
