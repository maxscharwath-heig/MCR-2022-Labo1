package shapes;

import graphics.Renderer;

import java.awt.Color;
import java.awt.geom.Point2D;

/**
 * A colored filled square shape
 *
 * @author Nicolas Crausaz
 * @author Maxime Scharwath
 */
public class FilledSquare extends AbstractSquare {

    public FilledSquare(int size, Point2D.Double position, Renderer renderer) {
        super(size, position, renderer);
    }

    @Override
    public Color getColor() {
        return Color.ORANGE;
    }
}
