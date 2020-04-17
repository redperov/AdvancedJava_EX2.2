import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    /**
     * Max pixel value a shape can be created at.
     */
    private static final int MAX_PIXEL = 200;

    /**
     * Default shape color.
     */
    private static final Color DEFAULT_COLOR = Color.red;

    /**
     * Default value of whether the shape is filled.
     */
    private static final boolean DEFAULT_IS_FILLED = true;

    private static final int PIXEL_ADDITION = 10;

    public static void main(String[] args) {

        // Create a list of shapes
        List<MyShape> originalShapes = initializeShapes();

        try {

            // Clone the original shapes into a separate list
            List<MyShape> clonedShapes = cloneShapes(originalShapes);

            // Modify the cloned shapes
            modifyShapes(clonedShapes);

            // Draw both the original and cloned shapes
            drawShapes(originalShapes, clonedShapes);
        } catch (CloneNotSupportedException e) {
            System.out.println("Failed to clone the list");
            e.printStackTrace();
        }
    }

    /**
     * Creates a list with shapes.
     *
     * @return list of shapes
     */
    public static List<MyShape> initializeShapes() {
        List<MyShape> shapes = new ArrayList<>();
        Random random = new Random();

        // Lines
        MyShape line1 = new MyLine(random.nextInt(MAX_PIXEL),
                random.nextInt(MAX_PIXEL), random.nextInt(MAX_PIXEL),
                random.nextInt(MAX_PIXEL), DEFAULT_COLOR);
        MyShape line2 = new MyLine(random.nextInt(MAX_PIXEL),
                random.nextInt(MAX_PIXEL), random.nextInt(MAX_PIXEL),
                random.nextInt(MAX_PIXEL), DEFAULT_COLOR);
        shapes.add(line1);
        shapes.add(line2);

        // Ovals
        MyShape oval1 = new MyOval(random.nextInt(MAX_PIXEL),
                random.nextInt(MAX_PIXEL), random.nextInt(MAX_PIXEL),
                random.nextInt(MAX_PIXEL), DEFAULT_COLOR, DEFAULT_IS_FILLED);
        MyShape oval2 = new MyOval(random.nextInt(MAX_PIXEL),
                random.nextInt(MAX_PIXEL), random.nextInt(MAX_PIXEL),
                random.nextInt(MAX_PIXEL), DEFAULT_COLOR, DEFAULT_IS_FILLED);
        shapes.add(oval1);
        shapes.add(oval2);

        // Rectangles
        MyShape rectangle1 = new MyRectangle(random.nextInt(MAX_PIXEL),
                random.nextInt(MAX_PIXEL), random.nextInt(MAX_PIXEL),
                random.nextInt(MAX_PIXEL), DEFAULT_COLOR, DEFAULT_IS_FILLED);
        MyShape rectangle2 = new MyRectangle(random.nextInt(MAX_PIXEL),
                random.nextInt(MAX_PIXEL), random.nextInt(MAX_PIXEL),
                random.nextInt(MAX_PIXEL), DEFAULT_COLOR, DEFAULT_IS_FILLED);
        shapes.add(rectangle1);
        shapes.add(rectangle2);

        return shapes;
    }

    /**
     * Clones a given list of shapes.
     *
     * @param shapes shapes to clone
     * @return list of cloned shapes
     * @throws CloneNotSupportedException indicates that cloning is not supported
     */
    private static List<MyShape> cloneShapes(List<MyShape> shapes) throws CloneNotSupportedException {
        List<MyShape> clonedShapes = new ArrayList<>(shapes.size());

        for (MyShape shape : shapes) {
            clonedShapes.add(shape.clone());
        }

        return clonedShapes;
    }

    /**
     * Modifies the given list of shapes.
     *
     * @param shapes list of shapes to modify
     */
    private static void modifyShapes(List<MyShape> shapes) {

        for (MyShape shape : shapes) {
            shape.setX1(shape.getX1() + PIXEL_ADDITION);
            shape.setY1(shape.getY1() + PIXEL_ADDITION);
            shape.setColor(Color.green);

            if (shape instanceof MyBoundedShape) {
                ((MyBoundedShape) shape).setFilled(false);
            }
        }
    }

    /**
     * Draws the given shapes.
     *
     * @param originalShapes original shapes to draw
     * @param clonedShapes   cloned shapes to draw
     */
    private static void drawShapes(List<MyShape> originalShapes, List<MyShape> clonedShapes) {
        new ShapesDrawing(originalShapes, clonedShapes);
    }
}
