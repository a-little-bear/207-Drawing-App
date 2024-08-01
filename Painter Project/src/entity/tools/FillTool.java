package entity.tools;

import interface_adapter.Controller;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import view.View;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.Queue;

/**
 * The FillTool class implements the Tool interface and provides functionality
 * for filling an area with a specified color using a flood fill algorithm.
 */
public class FillTool implements Tool {
    @Setter(AccessLevel.PROTECTED) @Getter private int size;
    @Setter(AccessLevel.PROTECTED) @Getter private Color color;

    /**
     * Checks if the specified coordinates are within the bounds of the image.
     *
     * @param x    the x coordinate
     * @param y    the y coordinate
     * @param maxX the maximum x coordinate
     * @param maxY the maximum y coordinate
     * @return true if the coordinates are within bounds, false otherwise
     */
    private boolean inBounds(int x, int y, int maxX, int maxY) {
        return x >= 0 && x < maxX && y >= 0 && y < maxY;
    }

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
