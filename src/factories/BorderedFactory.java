package factories;

import shapes.AbstractCircle;
import shapes.AbstractSquare;
import shapes.BorderedCircle;
import shapes.BorderedSquare;

import java.awt.geom.Point2D;

public class BorderedFactory extends AbstractShapeFactory {
    @Override
    public AbstractCircle createCircle(int size, Point2D.Double position) {
        return new BorderedCircle(size, position);
    }

    @Override
    public AbstractSquare createSquare(int size, Point2D.Double position) {
        return new BorderedSquare(size, position);
    }
}
