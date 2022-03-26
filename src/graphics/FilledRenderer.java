package graphics;

import java.awt.Graphics2D;

/**
 * Renderer for filled shapes
 *
 * @author Nicolas Crausaz
 * @author Maxime Scharwath
 */
public class FilledRenderer implements Renderer {
    @Override
    public void display(Graphics2D g, Bouncable b) {
        g.setColor(b.getColor());
        g.fill(b.getShape());
    }
}
