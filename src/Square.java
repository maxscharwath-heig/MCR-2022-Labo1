import java.awt.*;
import java.awt.geom.Point2D;

public class Square extends Shape {

    private static final Color color = Color.YELLOW;

    public Square(int size, Point2D position) {
        super(size, position);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g.create();
        System.out.println("Pain was called on square");
        g2d.setColor(color);
        g2d.fillRect (10, 10, 200, 200);
    }

}
