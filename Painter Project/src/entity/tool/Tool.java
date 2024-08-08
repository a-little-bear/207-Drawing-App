package entity.tool;

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

    void incrementSize(int increment);
}
