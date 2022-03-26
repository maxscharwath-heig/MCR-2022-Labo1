package shapes;

import graphics.Renderer;

import java.awt.Color;
import java.awt.geom.Point2D;

/**
 * A colored bordered square shape
 *
 * @author Nicolas Crausaz
 * @author Maxime Scharwath
 */
public class BorderedSquare extends AbstractSquare {

    public BorderedSquare(int size, Point2D.Double position, Renderer renderer) {
        super(size, position, renderer);
    }

    @Override
    public Color getColor() {
        return Color.RED;
    }
}
