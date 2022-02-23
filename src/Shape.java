import java.awt.*;

public abstract class Shape {
    protected final int size;
    public Vector2D position;
    public Vector2D velocity;

    public Shape(int size, Vector2D position) {
        this.size = size;
        this.position = position;
        this.velocity = Vector2D.fromAngleLength(Math.random() * Math.PI * 2, Math.random() * 10 + 0.1);
    }

    abstract void draw(Graphics g);
}
