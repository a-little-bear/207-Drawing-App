package entity.tools;

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
    @Getter private boolean isDrawing;

    /**
     * Set the drawing state of the paint tool.
     * @param isDrawing the new drawing state
     */
    public void setIsDrawing(boolean isDrawing) {
        this.isDrawing = isDrawing;
    }

    /**
     * Increments the size of the paint tool.
     *
     * @param increment the amount to increment the size by
     */
    public void incrementSize(int increment) {
        if (size < 1) {
            size = 1;
        } else {
            size += increment;
        }
    }
}
