package entity.tools;

import interface_adapter.Controller;
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
    private final View view;
    private final Controller controller;
    private final int size;
    private Color color;

    /**
     * Instantiates a new FillTool with the specified view and controller.
     *
     * @param view         the view associated with this tool
     * @param controller the controller managing the input devices
     */
    public FillTool(View view, Controller controller) {
        this.view = view;
        this.controller = controller;
        this.color = view.getColor();
        this.size = 5;
        // System.out.println("Fill tool created");
    }

    /**
     * Updates the fill tool by performing a flood fill operation starting from the current mouse coordinates.
     */
    @Override
    public void update() {
        BufferedImage image = view.canvasManager.getTopLayer().getCanvasImage();
        int x = controller.mouse.xCoord;
        int y = controller.mouse.yCoord;
        int initialColor = image.getRGB(x, y);
        int targetColor = color.getRGB();
        // System.out.println("pastColor: " + pastColor);
        if (initialColor != targetColor) {
            floodFill(x, y, initialColor, targetColor, image);
        }
    }

    /**
     * Performs a flood fill operation to fill an area with the target color.
     *
     * @param x            the starting x coordinate
     * @param y            the starting y coordinate
     * @param initialColor the initial color of the area to be filled
     * @param targetColor  the target color to fill the area with
     * @param image        the image to be filled
     */
    private void floodFill(int x, int y, int initialColor, int targetColor, BufferedImage image) {
        int width = image.getWidth();
        int height = image.getHeight();
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y));

        while (!queue.isEmpty()) {
            Point point = queue.poll();
            x = point.x;
            y = point.y;

            if (!inBounds(x, y, width, height)) {
                continue; // Skip points outside the image bounds
            }

            int currentColor = image.getRGB(x, y);
            if (currentColor != initialColor) {
                continue; // Skip points that do not match the initial color
            }

            // Set the pixel to the target color
            image.setRGB(x, y, targetColor);

            // Add neighboring points to the queue
            queue.add(new Point(x + 1, y));
            queue.add(new Point(x - 1, y));
            queue.add(new Point(x, y + 1));
            queue.add(new Point(x, y - 1));
        }
    }

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
     * Draws the cursor for the fill tool on the canvas.
     *
     * @param g2 the Graphics2D object to draw on
     */
    @Override
    public void draw(Graphics2D g2) {
        // this draws the cursor, what follows the mouse around
        int x = controller.mouse.xCoord;
        int y = controller.mouse.yCoord;
        g2.setColor(color);
        g2.fillOval(x, y, size, size);
        //g2.fillRect(x, y, size, size); // Updated to use size directly
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
    public void setColor(Color newColor) {
        color = newColor;
    }
}
