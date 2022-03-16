package factories;

import shapes.AbstractCircle;
import shapes.AbstractSquare;
import shapes.FilledCircle;
import shapes.FilledSquare;
import utility.Vector2D;

public class FilledFactory extends AbstractShapeFactory {
    @Override
    public AbstractCircle createCircle(int size, Vector2D position) {
        return new FilledCircle(size, position);
    }

    @Override
    public AbstractSquare createSquare(int size, Vector2D position) {
        return new FilledSquare(size, position);
    }
}
