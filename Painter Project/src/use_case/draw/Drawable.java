package use_case.draw;

import use_case.InputData;

import java.awt.*;

public interface Drawable{
    /**
     * Draws the object on the canvas.
     *
     * @param g2 the graphics object to draw on
     * @param inputData the input data
     * @param color the color of the object
     */
    void draw(Graphics2D g2, InputData inputData, Color color);
}
