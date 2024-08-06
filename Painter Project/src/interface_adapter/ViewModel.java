package interface_adapter;

import entity.canvas.CanvasManager;
import entity.tools.PaintTool;
import entity.tools.Tool;
import lombok.Getter;
import lombok.Setter;
import use_case.create_tool.CreatePaintTool;
import use_case.create_tool.CreateTool;

import java.awt.*;

public class ViewModel {
    @Getter private final Color backgroundColor = Color.WHITE;
    @Getter private final CanvasManager canvasManager;
    @Getter @Setter private Tool currentTool;
    @Getter @Setter private Color activeColor = Color.BLACK;
    private final int width;
    private final int height;

    public ViewModel(int width, int height) {
        this.width = width;
        this.height = height;
        this.canvasManager = new CanvasManager(width, height);
        CreateTool<PaintTool> ct = new CreatePaintTool();
        this.currentTool = ct.create(activeColor);
    }

    /**
     * Gets the dimension of the view model.
     *
     * @return the dimension of the view model
     */
    public Dimension getDimension() {
        return new Dimension(width, height);
    }

    /**
     * Paints the view.
     *
     * @param g2 the graphics object to paint
     */
    public void paint(Graphics2D g2) {
        canvasManager.draw(g2);
    }
}
