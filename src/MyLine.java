import java.awt.*;
import java.awt.geom.Line2D;

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
        // TODO check that Graphics2D can be used
        Graphics2D g2 = (Graphics2D) graphics;
        Line2D line = new Line2D.Float(this.getX1(), this.getY1(), this.getX2(), this.getY2());
        g2.setColor(this.getColor());
        g2.draw(line);
    }

    @Override
    public boolean equals(Object obj) {

        if (!(obj instanceof MyLine)) {
            return false;
        }
        MyLine otherLine = (MyLine) obj;
        double otherLineLength = this.calculateLength(otherLine);
        double currLineLength = this.calculateLength(this);

        // TODO this calculation might fail with double
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
