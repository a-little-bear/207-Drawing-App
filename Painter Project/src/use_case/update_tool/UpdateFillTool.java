package use_case.update_tool;

import entity.tool.FillTool;
import use_case.InputBoundary;
import use_case.InputData;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.Queue;

/**
 * The UpdateFillTool class implements the {@link UpdateTool} interface and provides functionality
 * for updating the state and behavior of a {@link FillTool}. This includes performing a flood fill
 * operation on the canvas when the fill tool is used.
 */
public class UpdateFillTool implements UpdateTool<FillTool> {

    /**
     * Updates the fill tool's behavior by performing a flood fill operation starting
     * from the specified coordinates on the canvas. This method is called when the fill
     * tool is used, filling the area with the current selected color.
     *
     * @param tool       The {@link FillTool} being used for the update.
     * @param inputData  The input data containing the current coordinates.
     * @param interactor The interactor that provides access to the canvas manager and other
     *                   application logic.
     */
    @Override
    public void update(FillTool tool, InputData inputData, InputBoundary interactor) {
        BufferedImage image = interactor.getCanvasManager()
                .getTopLayer().getCanvasImage();

        int x = inputData.getXCoord();
        int y = inputData.getYCoord();
        int initialColor = image.getRGB(x, y);
        int targetColor = interactor.getCurrentColor().getRGB();
        if (initialColor != targetColor) {
            floodFill(x, y, initialColor, targetColor, image);
        }
    }

    /**
     * Checks whether the given coordinates are within the bounds of the image.
     *
     * @param x    The x coordinate to check.
     * @param y    The y coordinate to check.
     * @param maxX The maximum x coordinate (image width).
     * @param maxY The maximum y coordinate (image height).
     * @return {@code true} if the coordinates are within bounds; {@code false} otherwise.
     */
    private boolean inBounds(int x, int y, int maxX, int maxY) {
        return x >= 0 && x < maxX && y >= 0 && y < maxY;
    }

    /**
     * Performs a flood fill operation to fill an area with the target color.
     * This algorithm uses a queue-based approach to iteratively fill connected areas
     * that match the initial color.
     *
     * @param x            The starting x coordinate.
     * @param y            The starting y coordinate.
     * @param initialColor The initial color of the area to be filled.
     * @param targetColor  The target color to fill the area with.
     * @param image        The image to be filled.
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
}
