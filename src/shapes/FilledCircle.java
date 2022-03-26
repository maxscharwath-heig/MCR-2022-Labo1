package shapes;

import graphics.Renderer;

import java.awt.Color;
import java.awt.geom.Point2D;

/**
 * A colored filled circle shape
 *
 * @author Nicolas Crausaz
 * @author Maxime Scharwath
 */
public class FilledCircle extends AbstractCircle {

    public FilledCircle(int size, Point2D.Double position, Renderer renderer) {
        super(size, position, renderer);
    }

    @Override
    public Color getColor() {
        return Color.BLUE;
    }
}
