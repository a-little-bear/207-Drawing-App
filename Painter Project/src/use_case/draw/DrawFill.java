package use_case.draw;

import use_case.InputData;

import java.awt.*;

public class DrawFill implements Drawable{
    private final int size = 5;

    /**
     * Draws the fill on the canvas.
     *
     * @param g2 the graphics object to draw on
     * @param inputData the input data
     * @param color the color of the fill
     */
    public void draw(Graphics2D g2, InputData inputData, Color color) {
        int x = inputData.getXCoord();
        int y = inputData.getYCoord();
        g2.setColor(color);
        g2.fillRect(x, y, size, size); // Updated to use size directly
    }

}
