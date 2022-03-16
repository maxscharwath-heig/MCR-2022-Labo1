public abstract class AbstractShape implements Bouncable {
    protected final int size;
    protected final Vector2D position;
    protected final Vector2D velocity;

    public AbstractShape(int size, Vector2D position) {
        this.size = size;
        this.position = position;
        this.velocity = Vector2D.fromAngleLength(Math.random() * Math.PI * 2, Math.random() * 10 + 0.1);
    }

    public Vector2D getPosition() {
        return position;
    }

    public Vector2D getVelocity() {
        return velocity;
    }

    Vector2D collisionOffset(Vector2D bound) {
        Vector2D offset = new Vector2D(0, 0);
        if (position.getX() < 0) {
            offset.setX(position.getX());
        }
        if (position.getX() + size > bound.getX()) {
            offset.setX(position.getX() + size - bound.getX());
        }
        if (position.getY() < 0) {
            offset.setY(position.getY());
        }
        if (position.getY() + size > bound.getY()) {
            offset.setY(position.getY() + size - bound.getY());
        }
        return offset;
    }
}
