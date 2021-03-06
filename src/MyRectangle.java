import java.awt.Graphics;
import java.awt.Color;

public class MyRectangle extends MyBoundedShape {

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
    public MyRectangle(int x1, int y1, int x2, int y2, Color color, boolean isFilled) {
        super(x1, y1, x2, y2, color, isFilled);
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(this.getColor());

        if (this.isFilled()) {
            graphics.fillRect(this.getX1(), this.getY1(), this.getX2(), this.getY2());
        } else {
            graphics.drawRect(this.getX1(), this.getY1(), this.getX2(), this.getY2());
        }
    }

    @Override
    public boolean equals(Object obj) {

        if (!(obj instanceof MyRectangle)) {
            return false;
        }
        MyRectangle otherRectangle = (MyRectangle) obj;

        // Check that the width and the height are equal
        return otherRectangle.getX2() == this.getX2() && otherRectangle.getY2() == this.getY2();
    }
}
