package shapes;

import graphics.Window;

import java.awt.*;
import java.awt.geom.Point2D;

public class FilledCircle extends AbstractCircle {

    public FilledCircle(int size, Point2D.Double position) {
        super(size, position);
    }

    @Override
    public Color getColor() {
        return Color.BLUE;
    }

    @Override
    public void draw() {
        var g = Window.getInstance().getGraphics();
        g.setColor(getColor());
        var shape = getShape().getBounds();
        g.fillOval(shape.x, shape.y, shape.width, shape.height);
    }
}
