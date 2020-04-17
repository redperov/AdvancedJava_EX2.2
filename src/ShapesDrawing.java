import javax.swing.JFrame;
import java.util.List;

public class ShapesDrawing {

    /**
     * Size of the frame.
     */
    private static final int FRAME_SIZE = 400;

    /**
     * Panel to draw the shapes on.
     */
    private ShapesPanel panel;

    /**
     * Constructor.
     * @param originalShapes original shapes to draw
     * @param clonedShapes cloned shapes to draw
     */
    public ShapesDrawing(List<MyShape> originalShapes, List<MyShape> clonedShapes) {
        JFrame frame = new JFrame("Shapes drawing");
        frame.setSize(FRAME_SIZE, FRAME_SIZE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        this.panel = new ShapesPanel(originalShapes, clonedShapes);
        frame.add(this.panel);
    }
}
