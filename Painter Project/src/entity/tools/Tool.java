package entity.tools;

import java.awt.*;

/**
 * The Tool interface defines the basic operations for tools used in drawing applications.
 */
public interface Tool {

    /**
     * Updates the tool's state or performs its primary action.
     */
    void update();

    /**
     * Draws the tool's cursor or representation on the canvas.
     *
     * @param g2 the Graphics2D object to draw on
     */
    void draw(Graphics2D g2);

    /**
     * Increments the size of the tool.
     *
     * @param incr the amount to increment the size by
     */
    void incrementSize(int incr);

    /**
     * Sets the color of the tool.
     *
     * @param newColor the new color to set
     */
    void setColor(Color newColor);
}
