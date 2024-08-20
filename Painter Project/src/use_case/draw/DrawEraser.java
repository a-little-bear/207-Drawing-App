package use_case.draw;

import use_case.InputData;

import java.awt.*;

/**
 * The DrawEraser class implements the {@link Drawable} interface and provides functionality
 * for erasing parts of the canvas by drawing a filled rectangle with the specified color.
 * The rectangle's position is determined by the input data, and the size is fixed.
 */
public class DrawEraser implements Drawable {
    private final int size = 20;

    /**
     * Draws a filled rectangle on the provided {@link Graphics2D} object at the coordinates
     * specified in the input data. The rectangle is filled with the specified color, simulating
     * the erasing action.
     *
     * @param g2        The {@link Graphics2D} object to draw on.
     * @param inputData The input data containing the coordinates for the rectangle.
     * @param color     The color to fill the rectangle with, typically matching the background color.
     */
    @Override
    public void draw(Graphics2D g2, InputData inputData, Color color) {
        int x = inputData.getXCoord();
        int y = inputData.getYCoord();
        g2.setColor(color);
        g2.fillRect(x, y, size, size); // Draws a filled rectangle using the specified size
    }
}
