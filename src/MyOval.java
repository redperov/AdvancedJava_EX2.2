import java.awt.Graphics;
import java.awt.Color;

public class MyOval extends MyBoundedShape {

    /**
     * Constructor.
     *
     * @param x1       first X coordinate
     * @param y1       first Y coordinate
     * @param x2       second X coordinate
     * @param y2       second Y coordinate
     * @param color    shape's color
     * @param isFilled indicates whether the shape is filled
     */
    public MyOval(int x1, int y1, int x2, int y2, Color color, boolean isFilled) {
        super(x1, y1, x2, y2, color, isFilled);
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(this.getColor());

        if (this.isFilled()) {
            graphics.fillOval(this.getX1(), this.getY1(), this.getX2(), this.getY2());
        } else {
            graphics.drawOval(this.getX1(), this.getY1(), this.getX2(), this.getY2());
        }
    }

    @Override
    public boolean equals(Object obj) {

        if (!(obj instanceof MyOval)) {
            return false;
        }
        MyOval otherOval = (MyOval) obj;

        // Check that the width and the height are equal
        return otherOval.getX2() == this.getX2() && otherOval.getY2() == this.getY2();
    }
}
