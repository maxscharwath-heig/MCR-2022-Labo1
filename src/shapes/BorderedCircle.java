package shapes;


import graphics.Window;

import java.awt.*;
import java.awt.geom.Point2D;

public class BorderedCircle extends AbstractCircle {

    public BorderedCircle(int size, Point2D.Double position) {
        super(size, position);
    }

    @Override
    public void draw() {
        var g = Window.getInstance().getGraphics();
        g.setColor(getColor());
        var shape = getShape().getBounds();
        g.drawOval(shape.x, shape.y, shape.width, shape.height);
    }

    @Override
    public Color getColor() {
        return Color.GREEN;
    }
}
