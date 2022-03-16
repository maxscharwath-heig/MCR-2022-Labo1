package factories;

import shapes.AbstractCircle;
import shapes.AbstractSquare;
import utility.Vector2D;

public abstract class AbstractShapeFactory {
    public abstract AbstractCircle createCircle(int size, Vector2D position);

    public abstract AbstractSquare createSquare(int size, Vector2D position);
}
