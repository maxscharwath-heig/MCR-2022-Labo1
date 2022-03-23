package graphics;

import graphics.Bouncable;
import graphics.Renderer;

import java.awt.*;

public class BorderedRenderer implements Renderer {
    @Override
    public void display(Graphics2D g, Bouncable b) {
        g.draw(b.getShape());
    }
}
