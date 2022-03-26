package factories;

import shapes.AbstractCircle;
import shapes.AbstractSquare;

import java.awt.geom.Point2D;

/**
 * Factory definition for shapes creation
 *
 * @author Nicolas Crausaz
 * @author Maxime Scharwath
 */
public abstract class AbstractShapeFactory {
    /**
     * Creates an AbstactCircle
     * @param size diameter of circle
     * @param position base position of circle
     * @return a new circle
     */
    public abstract AbstractCircle createCircle(int size, Point2D.Double position);

    /**
     * Creates an AbstractSquare
     * @param size side of square
     * @param position base position of square
     * @return a new square
     */
    public abstract AbstractSquare createSquare(int size, Point2D.Double position);
}
