package graphics;

import java.awt.Graphics2D;
import java.awt.event.KeyAdapter;

public interface Displayer {
    int getWidth();

    int getHeight();

    Graphics2D getGraphics();

    void repaint();

    void setTitle(String title);

    void addKeyListener(KeyAdapter ka);
}
