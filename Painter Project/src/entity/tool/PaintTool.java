package entity.tool;

import lombok.Getter;
import lombok.Setter;

import java.awt.*;

/**
 * The PaintTool class implements the Tool interface and provides functionality
 * for painting on the canvas with a specified color and size.
 */
public class PaintTool implements Tool {
    @Setter @Getter private int size;
    @Setter @Getter private Color paintColor;
    @Setter @Getter private boolean isDrawing;

    /**
     * Sets the drawing state of the paint tool.
     * This method is used to start or stop the paint tool's drawing action.
     *
     * @param isDrawing The new drawing state to set.
     * @return The updated drawing state.
     */
    public boolean setIsDrawing(boolean isDrawing) {
        this.isDrawing = isDrawing;
        return isDrawing;
    }

    /**
     * Increments the size of the paint tool.
     *
     * @param increment the amount to increment the size by
     */
    public void incrementSize(int increment) {
        size = Math.max(1, size + increment); // size does not go below 1
    }
}
