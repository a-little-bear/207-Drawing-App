package use_case;

import entity.canvas.CanvasManager;
import entity.tool.Tool;
import interface_adapter.Mouse;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;

/**
 * The InputData class stores and manages the current state of user inputs, including mouse coordinates,
 * the active state of the mouse, the current tool, and the current color. It serves as a data container
 * that is updated based on user interactions and is used throughout the application to drive tool behaviors.
 */
public class InputData {
    @Getter @Setter private int xCoord;
    @Getter @Setter private int yCoord;
    @Getter @Setter private int lastXCoord;
    @Getter @Setter private int lastYCoord;
    @Getter @Setter private boolean mouseIsActive;
    @Getter @Setter private Tool currentTool;
    @Getter @Setter private Color currentColor;
    private CanvasManager canvasManager;

    /**
     * Constructs an InputData object with the initial state derived from the given mouse, canvas manager,
     * current tool, and current color.
     *
     * @param mouse          The {@link Mouse} object representing the current state of the mouse.
     * @param canvasManager  The {@link CanvasManager} that manages the canvas layers and drawing operations.
     * @param currentTool    The current {@link Tool} being used.
     * @param currentColor   The current {@link Color} being used by the tool.
     */
    public InputData(Mouse mouse, CanvasManager canvasManager, Tool currentTool, Color currentColor){
        this.xCoord = mouse.xCoord;
        this.yCoord = mouse.yCoord;
        this.lastXCoord = mouse.xCoord;
        this.lastYCoord = mouse.yCoord;
        this.mouseIsActive = mouse.isActive;
        this.canvasManager = canvasManager;
        this.currentTool = currentTool;
        this.currentColor = currentColor;
    }

    /**
     * Updates the mouse-related fields in the InputData object based on the current state of the given mouse.
     *
     * @param mouse The {@link Mouse} object representing the current state of the mouse.
     */
    public void updateMouse(Mouse mouse){
        this.xCoord = mouse.xCoord;
        this.yCoord = mouse.yCoord;
        this.mouseIsActive = mouse.isActive;
    }

    /**
     * Retrieves whether the mouse is currently active.
     *
     * @return {@code true} if the mouse is active, {@code false} otherwise.
     */
    public boolean getMouseIsActive() {
        return mouseIsActive;
    }

    /**
     * Retrieves the current {@link CanvasManager} that manages the canvas layers and drawing operations.
     *
     * @return The current {@link CanvasManager}.
     */
    public CanvasManager getCanvasManager(){
        return canvasManager;
    }

    /**
     * Sets the {@link CanvasManager} to the specified instance.
     *
     * @param canvasManager The {@link CanvasManager} to be set.
     */
    public void setCanvasManager(CanvasManager canvasManager){
        this.canvasManager = canvasManager;
    }
}
