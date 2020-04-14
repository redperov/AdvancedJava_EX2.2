import javax.swing.JPanel;
import java.awt.*;
import java.util.List;

public class ShapesPanel extends JPanel {

    private List<MyShape> originalShapes;
    private List<MyShape> clonedShapes;

    public ShapesPanel(List<MyShape> originalShapes, List<MyShape> clonedShapes) {
        this.originalShapes = originalShapes;
        this.clonedShapes = clonedShapes;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Paint original shapes
        for (MyShape shape : this.originalShapes) {
            shape.draw(g);
        }

        // Paint cloned shapes
        for (MyShape shape : this.clonedShapes) {
            shape.draw(g);
        }
    }
}
