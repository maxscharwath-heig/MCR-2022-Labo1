package graphics;

import shapes.AbstractShape;

import java.awt.*;

public interface Bouncable {
    void draw();

    void move();

    Color getColor();

    AbstractShape getShape();
}
