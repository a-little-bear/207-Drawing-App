package entity.Tools;

import controllers.Controller;
import main.View;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.LinkedList;
import java.util.Queue;

public class FillTool implements Tool {
    private final View gp;
    private final Controller controller;
    private final int size;
    private Color color;

    public FillTool(View gp, Controller controller) {
        this.gp = gp;
        this.controller = controller;
        this.color = gp.getColor();
        this.size = 5;
        // System.out.println("Fill tool created");
    }

    @Override
    public void update() {
        BufferedImage image = gp.canvasManager.getTopLayer().getCanvasImage();
        int x = controller.mouse.xCoord;
        int y = controller.mouse.yCoord;
        int pastColor = image.getRGB(x, y);
        // System.out.println("pastColor: " + pastColor);
        if (pastColor != color.getRGB()) {
            floodFill(x, y, pastColor, color.getRGB(), image);
        }
    }

    private void floodFill(int x, int y, int initialColor, int targetColor, BufferedImage image) {
        if (initialColor == targetColor) {
            return; // No need to fill if the initial color is the same as the target color
        }

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

    private boolean inBounds(int x, int y, int maxX, int maxY) {
        return x >= 0 && x < maxX && y >= 0 && y < maxY;
    }

    @Override
    public void draw(Graphics2D g2) {
        // this draws the cursor, what follows the mouse around
        int x = controller.mouse.xCoord;
        int y = controller.mouse.yCoord;
        g2.setColor(color);
        g2.fillOval(x, y, size, size);
        //g2.fillRect(x, y, size, size); // Updated to use size directly
    }

    @Override
    public void incrementSize(int increment) {
    }

    @Override
    public void setColor(Color newColor) {
        color = newColor;
    }
}
