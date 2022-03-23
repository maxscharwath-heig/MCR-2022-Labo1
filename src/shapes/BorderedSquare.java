package shapes;

import graphics.Window;

import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.geom.RectangularShape;

/**
 * A colored bordered square shape
 *
 * @author Nicolas Crausaz
 * @author Maxime Scharwath
 */
public class BorderedSquare extends AbstractSquare {

    public BorderedSquare(int size, Point2D.Double position) {
        super(size, position);
    }

    @Override
    public Color getColor() {
        return Color.RED;
    }
}
