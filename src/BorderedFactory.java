public class BorderedFactory extends AbstractShapeFactory {
    @Override
    public AbstractCircle createCircle(int size, Vector2D position) {
        return new BorderedCircle(size, position);
    }

    @Override
    public AbstractSquare createSquare(int size, Vector2D position) {
        return new BorderedSquare(size, position);
    }
}
