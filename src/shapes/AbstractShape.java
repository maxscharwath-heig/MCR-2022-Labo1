package shapes;

import graphics.Bouncable;
import graphics.Renderer;
import graphics.Window;

import java.awt.Shape;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

/**
 * A bouncing shape
 *
 * @author Nicolas Crausaz
 * @author Maxime Scharwath
 */
public abstract class AbstractShape implements Bouncable {
    private final Point2D.Double velocity;
    private final Shape shape;
    private final Renderer renderer;

    protected AbstractShape(Shape shape, Renderer renderer) {
        this.renderer = renderer;
        this.shape = shape;
        double angle = Math.random() * 2 * Math.PI;
        double length = Math.random() * 10 + 0.1;
        this.velocity = new Point2D.Double((Math.cos(angle) * length), (Math.sin(angle) * length));
    }

    @Override
    public void draw() {
        renderer.display(Window.getInstance().getGraphics(), this);
    }

    @Override
    public Shape getShape() {
        return shape;
    }

    /**
     * Check if collision with border of displayer and reacts to it
     * @return
     */
    protected Rectangle2D checkAndReactToCollision() {
        Window window = Window.getInstance();
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

        return bounds;
    }
}
