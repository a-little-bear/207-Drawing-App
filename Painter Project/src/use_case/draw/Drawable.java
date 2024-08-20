package use_case.draw;

import use_case.InputData;

import java.awt.*;

/**
 * The Drawable interface defines a contract for classes that can perform drawing operations.
 * Implementing classes are responsible for rendering graphical content based on the provided
 * input data and color.
 */
public interface Drawable {

    /**
     * Draws graphical content onto the provided {@link Graphics2D} object.
     * The drawing operation uses the given input data and color.
     *
     * @param g2        The {@link Graphics2D} object to draw on.
     * @param inputData The input data that provides context or coordinates for the drawing operation.
     * @param color     The color to be used for the drawing operation.
     */
    void draw(Graphics2D g2, InputData inputData, Color color);
}
