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
    int getWidth();

    int getHeight();

    Graphics2D getGraphics();

    void repaint();

    void setTitle(String title);

    void addKeyListener(KeyAdapter ka);
}
