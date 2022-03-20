package factories;

import shapes.AbstractCircle;
import shapes.AbstractSquare;

import java.awt.geom.Point2D;

/**
 * Factory definition for shapes creation
 */
public abstract class AbstractShapeFactory {
    public abstract AbstractCircle createCircle(int size, Point2D.Double position);

    public abstract AbstractSquare createSquare(int size, Point2D.Double position);
}
