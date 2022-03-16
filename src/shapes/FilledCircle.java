package shapes;

import shapes.AbstractCircle;
import utility.Vector2D;

import java.awt.*;

public class FilledCircle extends AbstractCircle {

    public FilledCircle(int size, Vector2D position) {
        super(size, position);
    }

    @Override
    public Color getColor() {
        return Color.BLUE;
    }
}
