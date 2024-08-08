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

    public boolean setIsDrawing(boolean isDrawing) {
        this.isDrawing = isDrawing;
        return isDrawing;
    }

    private int lastX, lastY;


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
