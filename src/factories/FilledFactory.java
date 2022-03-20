package factories;

import shapes.AbstractCircle;
import shapes.AbstractSquare;
import shapes.FilledCircle;
import shapes.FilledSquare;
import java.awt.geom.Point2D;

/**
 * Factory for filled shapes creation
 */
public class FilledFactory extends AbstractShapeFactory {
    @Override
    public AbstractCircle createCircle(int size, Point2D.Double position) {
        return new FilledCircle(size, position);
    }

    @Override
    public AbstractSquare createSquare(int size, Point2D.Double position) {
        return new FilledSquare(size, position);
    }
}
