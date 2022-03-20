package shapes;


import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

public abstract class AbstractCircle extends AbstractShape {

    public AbstractCircle(int size, Point2D.Double position) {
        super(new Ellipse2D.Double(position.x, position.y, size, size));
    }

    @Override
    public void move() {
        Rectangle2D bounds = checkAndReactToCollision();
        ((Ellipse2D) this.getShape()).setFrame(bounds);
    }
}
