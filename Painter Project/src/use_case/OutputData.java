package use_case;

import entity.canvas.CanvasManager;
import entity.tool.Tool;

import java.awt.*;
import lombok.Getter;

/**
 * The OutputData class serves as a container for the data that needs to be presented to the user.
 * It holds the current state of the canvas, the tool in use, and the selected color. This data
 * is updated based on the application's state and is used by the presenter to update the view.
 */
public class OutputData {

    @Getter private CanvasManager canvasManager;
    @Getter private Tool currentTool;
    @Getter private Color currentColor;

    /**
     * Constructs an OutputData object with the initial canvas manager state.
     *
     * @param canvasManager The {@link CanvasManager} that manages the canvas layers and drawing operations.
     */
    public OutputData(CanvasManager canvasManager) {
        this.canvasManager = canvasManager;
    }

    /**
     * Updates the output data with the latest canvas manager, current tool, and current color.
     * This method is called to ensure that the presentation layer reflects the current state
     * of the application.
     *
     * @param canvasManager The updated {@link CanvasManager}.
     * @param currentTool   The current {@link Tool} being used.
     * @param currentColor  The current {@link Color} selected for the tool.
     */
    public void update(CanvasManager canvasManager, Tool currentTool, Color currentColor) {
        this.canvasManager = canvasManager;
        this.currentTool = currentTool;
        this.currentColor = currentColor;
    }
}
