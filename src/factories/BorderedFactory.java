package factories;

import graphics.BorderedRenderer;
import graphics.Renderer;
import shapes.AbstractCircle;
import shapes.AbstractSquare;
import shapes.BorderedCircle;
import shapes.BorderedSquare;

import java.awt.geom.Point2D;

/**
 * Factory for bordered shapes creation
 *
 * @author Nicolas Crausaz
 * @author Maxime Scharwath
 */
public class BorderedFactory extends AbstractShapeFactory {
    private static final Renderer renderer = new BorderedRenderer();

    @Override
    public AbstractCircle createCircle(int size, Point2D.Double position) {
        return new BorderedCircle(size, position, renderer);
    }

    @Override
    public AbstractSquare createSquare(int size, Point2D.Double position) {
        return new BorderedSquare(size, position, renderer);
    }
}
