package graphics;

import java.awt.Color;
import java.awt.Shape;

/**
 * Define the behaviour of a bouncing shape
 *
 * @author Nicolas Crausaz
 * @author Maxime Scharwath
 */
public interface Bouncable {
    void draw();

    void move();

    Color getColor();

    Shape getShape();
}
