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
