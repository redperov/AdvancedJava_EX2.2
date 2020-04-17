import java.awt.Color;

public abstract class MyBoundedShape extends MyShape {

    /**
     * Indicates whether the shape is filled.
     */
    private boolean isFilled;

    /**
     * Constructor.
     *
     * @param x1    first X coordinate
     * @param y1    first Y coordinate
     * @param x2    second X coordinate
     * @param y2    second Y coordinate
     * @param color shape's color
     * @param isFilled indicates whether the shape is filled
     */
    public MyBoundedShape(int x1, int y1, int x2, int y2, Color color, boolean isFilled) {
        super(x1, y1, x2, y2, color);
        this.isFilled = isFilled;
    }

    public boolean isFilled() {
        return isFilled;
    }

    public void setFilled(boolean filled) {
        isFilled = filled;
    }
}
