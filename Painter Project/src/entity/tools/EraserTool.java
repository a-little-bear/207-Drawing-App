package entity.tools;

import interface_adapter.Controller;
import lombok.Getter;
import lombok.Setter;
import view.View;

import java.awt.*;

/**
 * The EraserTool class implements the Tool interface and provides functionality
 * for erasing parts of the canvas by drawing with a specified color and size.
 */
public class EraserTool implements Tool {
    @Setter @Getter private int size;
    @Setter @Getter private Color color;
    @Setter @Getter private boolean isDrawing;

    public boolean setIsDrawing(boolean isDrawing) {
        this.isDrawing = isDrawing;
        return isDrawing;
    }


    /**
     * Increments the size of the eraser tool.
     *
     * @param increment the amount to increment the size by
     */
    public void incrementSize(int increment) {
        size = Math.max(1, size + increment);

    }

    /**
     * Sets the color of the eraser tool. This method is not used for the eraser tool.
     *
     * @param newColor the new color to set
     */
    @Override
    public void setPaintColor(Color newColor) {
        // No implementation needed for eraser tool
    }

    // Getter for size
    public int getSize() {
        return size;
    }
}
