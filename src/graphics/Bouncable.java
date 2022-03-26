package graphics;

import java.awt.Color;
import java.awt.Shape;

public interface Bouncable {
    void draw();

    void move();

    Color getColor();

    Shape getShape();
}
