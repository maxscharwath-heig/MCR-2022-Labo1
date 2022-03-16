import java.awt.*;

public class BorderedSquare extends AbstractSquare {

    public BorderedSquare(int size, Vector2D position) {
        super(size, position);
    }

    @Override
    public Color getColor() {
        return Color.RED;
    }

    @Override
    public AbstractShape getShape() {
        return null;
    }
}
