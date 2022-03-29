package graphics;

import java.awt.*;

/**
 * Define the behaviour of a bouncing shape
 *
 * @author Nicolas Crausaz
 * @author Maxime Scharwath
 */
public interface Bouncable {
    /**
     * Triggers the drawing of a bouncable
     */
    void draw();

    /**
     * Move a bouncable
     */
    void move();

    /**
     * Get the color of a bouncable
     * @return color of bouncable
     */
    Color getColor();

    /**
     * Get the shape of a bouncable
     * @return shape of bouncable
     */
    Shape getShape();
}
