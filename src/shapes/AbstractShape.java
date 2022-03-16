package shapes;

import graphics.Bouncable;

import java.awt.*;
import java.awt.geom.Point2D;

public abstract class AbstractShape implements Bouncable {
    protected final Point2D.Double velocity;
    private final Shape shape;

    public AbstractShape(Shape shape) {
        this.shape = shape;
        double angle = Math.random() * 2 * Math.PI;
        double length = Math.random() * 10 + 0.1;
        this.velocity = new Point2D.Double((Math.cos(angle) * length), (Math.sin(angle) * length));

    }

    @Override
    public Shape getShape() {
        return shape;
    }
}
