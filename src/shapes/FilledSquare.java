package shapes;

import shapes.AbstractShape;
import shapes.AbstractSquare;
import utility.Vector2D;

import java.awt.*;

public class FilledSquare extends AbstractSquare {

    public FilledSquare(int size, Vector2D position) {
        super(size, position);
    }

    @Override
    public Color getColor() {
        return Color.ORANGE;
    }

    @Override
    public AbstractShape getShape() {
        return null;
    }
}
