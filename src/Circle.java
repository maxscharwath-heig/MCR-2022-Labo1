import java.awt.*;

public class Circle extends Shape {

    private static final Color color = Color.BLUE;

    public Circle(int size, Vector2D position) {
        super(size, position);
    }

    @Override
    void draw(Graphics g) {
        g.setColor(color);
        g.fillOval((int) position.getX(), (int) position.getY(), size, size);
    }
}
