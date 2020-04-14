import javax.swing.*;
import java.util.List;

public class ShapesDrawing {

    private static final int FRAME_SIZE = 400;

    private ShapesPanel panel;

    public ShapesDrawing(List<MyShape> originalShapes, List<MyShape> clonedShapes) {
        JFrame frame = new JFrame("Shapes drawing");
        frame.setSize(FRAME_SIZE, FRAME_SIZE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        this.panel = new ShapesPanel(originalShapes, clonedShapes);
        frame.add(this.panel);
    }
}
