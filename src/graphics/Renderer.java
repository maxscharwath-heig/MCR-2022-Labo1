package graphics;

import java.awt.Graphics2D;

public interface Renderer {
    /**
     * Display a bouncable
     * @param g graphics to display the bouncable with
     * @param b the bouncable to display
     */
    void display(Graphics2D g, Bouncable b);
}
