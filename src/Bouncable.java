import java.awt.*;

public interface Bouncable {
    void draw();

    void move();

    Renderer getRenderer();

    Color getColor();

    AbstractShape getShape();
}
