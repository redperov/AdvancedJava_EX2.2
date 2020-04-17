import java.awt.Graphics;
import java.awt.Color;

public class MyLine extends MyShape {

    /**
     * Constructor.
     *
     * @param x1    first X coordinate
     * @param y1    first Y coordinate
     * @param x2    second X coordinate
     * @param y2    second Y coordinate
     * @param color shape's color
     */
    public MyLine(int x1, int y1, int x2, int y2, Color color) {
        super(x1, y1, x2, y2, color);
    }

    @Override
    public void draw(Graphics graphics) {
        graphics.setColor(this.getColor());
        graphics.drawLine(this.getX1(), this.getY1(), this.getX2(), this.getY2());
    }

    @Override
    public boolean equals(Object obj) {

        if (!(obj instanceof MyLine)) {
            return false;
        }
        MyLine otherLine = (MyLine) obj;
        double otherLineLength = this.calculateLength(otherLine);
        double currLineLength = this.calculateLength(this);

        return currLineLength == otherLineLength;
    }

    /**
     * Calculates the length of a line.
     *
     * @param line line to calculate its length
     * @return line length
     */
    private double calculateLength(MyLine line) {
        return Math.sqrt(Math.pow(line.getX2() - line.getX1(), 2)
                + Math.pow(line.getY2() - line.getY1(), 2));
    }
}
