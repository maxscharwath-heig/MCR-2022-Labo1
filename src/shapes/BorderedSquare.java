package shapes;

import graphics.Window;

import java.awt.*;
import java.awt.geom.Point2D;

public class BorderedSquare extends AbstractSquare {

    public BorderedSquare(int size, Point2D.Double position) {
        super(size, position);
    }

    @Override
    public Color getColor() {
        return Color.RED;
    }

    @Override
    public void draw() {
        var g = Window.getInstance().getGraphics();
        g.setColor(getColor());
        var shape = getShape().getBounds();
        g.drawRect(shape.x, shape.y, shape.width, shape.height);
    }
}
