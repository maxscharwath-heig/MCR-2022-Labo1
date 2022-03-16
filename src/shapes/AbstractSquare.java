package shapes;

import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

public abstract class AbstractSquare extends AbstractShape {

    public AbstractSquare(int size, Point2D.Double position) {
        super(new Rectangle2D.Double(position.x, position.y, size, size));
    }

    @Override
    public void move() {
        //todo BAD CODE
        graphics.Window window = graphics.Window.getInstance();
        Rectangle2D bounds = this.getShape().getBounds2D();
        bounds.setRect(bounds.getX() + velocity.x, bounds.getY() + velocity.y, bounds.getWidth(), bounds.getHeight());
        Point2D.Double offset = new Point2D.Double();
        if (bounds.getX() < 0) {
            offset.x = bounds.getX();
        }
        if (bounds.getX() + bounds.getWidth() > window.getWidth()) {
            offset.x = bounds.getX() + bounds.getWidth() - window.getWidth();
        }
        if (bounds.getY() < 0) {
            offset.y = bounds.getY();
        }
        if (bounds.getY() + bounds.getHeight() > window.getHeight()) {
            offset.y = bounds.getY() + bounds.getHeight() - window.getHeight();
        }
        bounds.setRect(bounds.getX() - offset.x, bounds.getY() - offset.y, bounds.getWidth(), bounds.getHeight());
        if (offset.x != 0) velocity.x *= -1;
        if (offset.y != 0) velocity.y *= -1;
        ((Rectangle2D) this.getShape()).setFrame(bounds);
    }
}
