package entity.tool;

import java.awt.*;

/**
 * The Tool interface defines the basic operations for tools used in drawing applications.
 */
public interface Tool {

    /**
     * Sets the color of the tool.
     *
     * @param newColor The new color to set for the tool.
     */
    void setPaintColor(Color newColor);

    /**
     * Increments the size of the tool by the specified amount.
     *
     * @param increment The amount to increase (or decrease) the tool's size by.
     */
    void incrementSize(int increment);
}
