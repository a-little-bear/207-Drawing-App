package entity.tools;

import controllers.Controller;
import main.View;

import java.awt.*;

/**
 * The PaintTool class implements the Tool interface and provides functionality
 * for painting on the canvas with a specified color and size.
 */
public class PaintTool implements Tool {
    private final View view;
    private final Controller controller;
    private int size;
    private Color color;
    private int lastX, lastY;
    private boolean isDrawing;

    /**
     * Instantiates a new PaintTool with the specified view and controller.
     *
     * @param view         the view associated with this tool
     * @param controller the controller managing the input devices
     */
    public PaintTool(View view, Controller controller) {
        this.view = view;
        this.controller = controller;
        this.color = view.getColor();
        this.size = 5;
        this.isDrawing = false;
        // System.out.println("PaintTool Created");
    }

    /**
     * Updates the paint tool by drawing a line from the last point to the current point.
     */
    @Override
    public void update() {
        int x = controller.mouse.xCoord;
        int y = controller.mouse.yCoord;

        if (controller.mouse.isActive) {
            if (!isDrawing) {
                // Starting a new line
                lastX = x;
                lastY = y;
                isDrawing = true;
            }
            // Draw the line from the last point to the current point
            view.canvasManager.paintLine(lastX, lastY, x, y, color, size);
            lastX = x;
            lastY = y;
        } else {
            isDrawing = false;
        }
    }

    /**
     * Draws the paint tool cursor on the canvas.
     *
     * @param g2 the Graphics2D object to draw on
     */
    @Override
    public void draw(Graphics2D g2) {
        int x = controller.mouse.xCoord;
        int y = controller.mouse.yCoord;
        g2.setColor(color);
        g2.fillRect(x, y, size, size); // Updated to use size directly
    }

    /**
     * Sets the color of the paint tool.
     *
     * @param newColor the new color to set
     */
    @Override
    public void setColor(Color newColor) {
        color = newColor;
    }

    /**
     * Increments the size of the paint tool.
     *
     * @param increment the amount to increment the size by
     */
    public void incrementSize(int increment) {
        if (size < 1) {
            size = 1;
        } else {
            size += increment;
        }
    }
}
