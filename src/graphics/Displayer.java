package graphics;

import java.awt.Graphics2D;
import java.awt.event.KeyAdapter;

/**
 * Define behaviour of a displayer
 *
 * @author Nicolas Crausaz
 * @author Maxime Scharwath
 */
public interface Displayer {
    /**
     * Get the width of the displayer
     * @return width of displayer
     */
    int getWidth();

    /**
     * Get the height of the displayer
     * @return height of displayer
     */
    int getHeight();

    /**
     * Get the current displayed graphics of displayer
     * @return current graphic
     */
    Graphics2D getGraphics();

    /**
     * Triggers the creation and rendering of displayer
     */
    void repaint();

    /**
     * Set the title of displayer
     * @param title text to set as title
     */
    void setTitle(String title);

    /**
     * Bind a KeyAdapter to displayer's listener
     * @param ka KeyAdapter to bind
     */
    void addKeyListener(KeyAdapter ka);
}
