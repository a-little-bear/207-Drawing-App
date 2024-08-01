package use_case.update_tool;

import entity.tools.FillTool;
import use_case.InputBoundary;
import use_case.InputData;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.Queue;

public class UpdateFillTool implements UpdateTool<FillTool>{

    public void update(FillTool tool, InputData inputData, InputBoundary interactor) {
        BufferedImage image = interactor.getPresenter().getViewModel().getCanvasManager()
                .getTopLayer().getCanvasImage();
        int x = inputData.getXCoord();
        int y = inputData.getYCoord();
        int initialColor = image.getRGB(x, y);
        int targetColor = interactor.getPresenter().getViewModel().getActiveColor().getRGB();
        // System.out.println("pastColor: " + pastColor);
        if (initialColor != targetColor) {
            floodFill(x, y, initialColor, targetColor, image);
        }
    }

    private boolean inBounds(int x, int y, int maxX, int maxY) {
        return x >= 0 && x < maxX && y >= 0 && y < maxY;
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
}
