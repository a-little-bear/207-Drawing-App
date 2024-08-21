package interface_adapter;

import entity.canvas.CanvasManager;
import entity.tool.Tool;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;

/**
 * The ViewModel class represents the state and data of the view in the application.
 */
public class ViewModel {
    @Getter private final Color backgroundColor = Color.WHITE;
    @Getter @Setter public Tool currentTool;
    @Getter @Setter private Color activeColor = Color.BLACK;
    private int screenWidth;
    private int screenHeight;
    @Getter private CanvasManager canvasManager;

    /**
     * Constructs a new ViewModel with the specified tool and canvas manager.
     * The screen dimensions are initialized based on the canvas manager's dimensions.
     *
     * @param tool          The initial tool to be used in the view.
     * @param canvasManager The canvas manager that manages the canvas layers.
     */
    public ViewModel(Tool tool, CanvasManager canvasManager) {
        this.currentTool = tool;
        this.canvasManager = canvasManager;
        this.screenWidth = canvasManager.getDimension().width;
        this.screenHeight = canvasManager.getDimension().height;
    }

    /**
     * Returns the dimensions of the screen managed by this ViewModel.
     *
     * @return The dimensions of the screen.
     */
    public Dimension getDimension() {
        return new Dimension(screenWidth, screenHeight);
    }

    /**
     * Sets a new CanvasManager for this ViewModel.
     * This method updates the internal reference to the CanvasManager.
     *
     * @param canvasManager The new CanvasManager to be set.
     */
    public void setCanvasManager(CanvasManager canvasManager) {
        this.canvasManager = canvasManager;
    }

    /**
     * Paints the current state of the canvas onto the provided Graphics2D object.
     *
     * @param g The Graphics2D object on which to draw the canvas.
     */
    public void paint(Graphics2D g){
        canvasManager.draw(g);
    }
}
