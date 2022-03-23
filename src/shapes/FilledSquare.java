package shapes;

import graphics.Window;

import java.awt.*;
import java.awt.geom.Point2D;

/**
 * A colored filled square shape
 *
 * @author Nicolas Crausaz
 * @author Maxime Scharwath
 */
public class FilledSquare extends AbstractSquare {

    public FilledSquare(int size, Point2D.Double position) {
        super(size, position);
    }

    @Override
    public Color getColor() {
        return Color.ORANGE;
    }
}
