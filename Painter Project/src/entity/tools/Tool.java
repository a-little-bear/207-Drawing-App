package entity.tools;

import java.awt.*;

/**
 * The Tool interface defines the basic operations for tools used in drawing applications.
 */
public interface Tool {

    /**
     * Sets the color of the tool.
     *
     * @param newColor the new color to set
     */
    void setPaintColor(Color newColor);

    /**
     * Increments the size of the tool.
     *
     * @param increment the amount to increment the size by
     */
    void incrementSize(int increment);
}
