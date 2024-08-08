package entity.tools;


import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;

/**
 * The FillTool class implements the Tool interface and provides functionality
 * for filling an area with a specified color using a flood fill algorithm.
 */
public class FillTool implements Tool {
    @Setter(AccessLevel.PROTECTED) @Getter private int size;
    @Setter(AccessLevel.PROTECTED) @Getter private Color color;

    /**
     * Increments the size of the fill tool. This method is not used for the fill tool.
     *
     * @param increment the amount to increment the size by
     */
    @Override
    public void incrementSize(int increment) {
        // No implementation needed for fill tool
    }

    /**
     * Sets the color of the fill tool.
     *
     * @param newColor the new color to set
     */
    @Override
    public void setPaintColor(Color newColor) {
        color = newColor;
    }
}
