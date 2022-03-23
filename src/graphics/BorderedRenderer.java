package graphics;

import java.awt.*;

public class BorderedRenderer implements Renderer {
    @Override
    public void display(Graphics2D g, Bouncable b) {
        g.setColor(b.getColor());
        g.setStroke(new BasicStroke(2.0f));
        g.draw(b.getShape());
    }
}
