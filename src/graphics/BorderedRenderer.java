package graphics;

import java.awt.Graphics2D;
import java.awt.BasicStroke;

/**
 * Renderer for bordered shapes
 *
 * @author Nicolas Crausaz
 * @author Maxime Scharwath
 */
public class BorderedRenderer implements Renderer {
    @Override
    public void display(Graphics2D g, Bouncable b) {
        g.setColor(b.getColor());
        g.setStroke(new BasicStroke(2.0f));
        g.draw(b.getShape());
    }
}
