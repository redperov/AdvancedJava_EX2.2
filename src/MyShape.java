import java.awt.Color;
import java.awt.Graphics;

public abstract class MyShape implements Cloneable {

    // TODO should it be double?
    private int x1;
    private int y1;
    private int x2;
    private int y2;
    private Color color;

    /**
     * Constructor.
     *
     * @param x1    first X coordinate
     * @param y1    first Y coordinate
     * @param x2    second X coordinate
     * @param y2    second Y coordinate
     * @param color shape's color
     */
    public MyShape(int x1, int y1, int x2, int y2, Color color) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.color = color;
    }

    /**
     * Draws the shape.
     *
     * @param graphics used to draw the shape
     */
    public abstract void draw(Graphics graphics);

    @Override
    protected MyShape clone() throws CloneNotSupportedException {
        return (MyShape) super.clone();
    }

    public int getX1() {
        return x1;
    }

    public void setX1(int x1) {
        this.x1 = x1;
    }

    public int getY1() {
        return y1;
    }

    public void setY1(int y1) {
        this.y1 = y1;
    }

    public int getX2() {
        return x2;
    }

    public void setX2(int x2) {
        this.x2 = x2;
    }

    public int getY2() {
        return y2;
    }

    public void setY2(int y2) {
        this.y2 = y2;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
