import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    private static final int MAX_PIXEL = 200;
    private static final Color DEFAULT_COLOR = Color.red;
    private static final boolean DEFAULT_IS_FILLED = true;
    private static final int PIXEL_ADDITION = 10;

    public static void main(String[] args) {

        List<MyShape> originalShapes = initializeShapes();

        try {
            List<MyShape> clonedShapes = cloneShapes(originalShapes);
            modifyShapes(clonedShapes);
            drawShape(originalShapes, clonedShapes);
        } catch (CloneNotSupportedException e) {
            System.out.println("Failed to clone the list");
            e.printStackTrace();
        }
    }

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

    private static List<MyShape> cloneShapes(List<MyShape> shapes) throws CloneNotSupportedException {
        List<MyShape> clonedShapes = new ArrayList<>(shapes.size());

        for (MyShape shape : shapes) {
            clonedShapes.add(shape.clone());
        }

        return clonedShapes;
    }

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

    private static void drawShape(List<MyShape> originalShapes, List<MyShape> clonedShapes) {
        new ShapesDrawing(originalShapes, clonedShapes);
    }
}
