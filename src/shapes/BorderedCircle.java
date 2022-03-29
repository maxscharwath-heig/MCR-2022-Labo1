package shapes;

import graphics.Renderer;

import java.awt.*;
import java.awt.geom.Point2D;

/**
 * A colored bordered circle shape
 *
 * @author Nicolas Crausaz
 * @author Maxime Scharwath
 */
public class BorderedCircle extends AbstractCircle {

    public BorderedCircle(int size, Point2D.Double position, Renderer renderer) {
        super(size, position, renderer);
    }

    @Override
    public Color getColor() {
        return Color.GREEN;
    }
}
