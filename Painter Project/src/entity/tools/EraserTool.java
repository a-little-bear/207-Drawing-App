package entity.tools;

import interface_adapter.Controller;
import view.View;

import java.awt.*;

/**
 * The EraserTool class implements the Tool interface and provides functionality
 * for erasing parts of the canvas by drawing with a specified color and size.
 */
public class EraserTool implements Tool {
    private final View view;
    private final Controller controller;
    private int size;
    private final Color color;
    private int lastX, lastY;
    private boolean isDrawing;

    /**
     * Instantiates a new EraserTool with the specified view and controller.
     *
     * @param view         the view associated with this tool
     * @param controller the controller managing the input devices
     */
    public EraserTool(View view, Controller controller) {
        this.view = view;
        this.controller = controller;
        this.color = Color.WHITE; // TODO: GET TRANSPARENT TO WORK INSTEAD OF WHITE
        this.size = 20;
        this.isDrawing = false;
        // System.out.println("EraserTool Created");
    }

    /**
     * Updates the eraser tool by drawing a line from the last point to the current point.
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
     * Draws the eraser tool on the canvas.
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
     * Increments the size of the eraser tool.
     *
     * @param increment the amount to increment the size by
     */
    public void incrementSize(int increment) {
        size = Math.max(1, size + increment);

    }

    /**
     * Sets the color of the eraser tool. This method is not used for the eraser tool.
     *
     * @param newColor the new color to set
     */
    @Override
    public void setColor(Color newColor) {
        // No implementation needed for eraser tool
    }

    // Getter for size
    public int getSize() {
        return size;
    }
}
