import java.awt.*;

public class BorderedCircle extends AbstractCircle {

    public BorderedCircle(int size, Vector2D position) {
        super(size, position);
    }

    @Override
    public Color getColor() {
        return Color.GREEN;
    }

    @Override
    public AbstractShape getShape() {
        return null;
    }
}
