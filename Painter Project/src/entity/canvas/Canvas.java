package entity.canvas;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.Serializable;

/**
 * The Canvas class provides functionality for drawing and manipulating a canvas.
 */
public class Canvas implements Serializable {
    private BufferedImage canvasImage;
    private final int width;
    private final int height;

    /**
     * Instantiates a new Canvas with the specified width and height.
     *
     * @param width  the width of the canvas
     * @param height the height of the canvas
     */
    public Canvas(int width, int height) {
        this.width = width;
        this.height = height;
        canvasImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        // clearCanvas();
    }

    /**
     * Clears the canvas by filling it with a transparent color.
     */
    public void clearCanvas() {
        canvasImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
    }

    /**
     * Returns the BufferedImage representation of the canvas.
     *
     * @return the canvas image
     */
    public BufferedImage getCanvasImage() {
        return canvasImage;
    }

    /**
     * Paints a filled rectangle at the specified location on the canvas.
     *
     * @param x     the x coordinate of the rectangle
     * @param y     the y coordinate of the rectangle
     * @param color the color of the rectangle
     * @param size  the size of the rectangle
     */
    public void paintArea(int x, int y, Color color, int size) {
        Graphics2D g2 = canvasImage.createGraphics();
        g2.setColor(color);
        g2.fillRect(x, y, size, size);
        g2.dispose();
    }

    /**
     * Paints a line between two points on the canvas using Bresenham's line algorithm.
     *
     * @param x1    the starting x coordinate of the line
     * @param y1    the starting y coordinate of the line
     * @param x2    the ending x coordinate of the line
     * @param y2    the ending y coordinate of the line
     * @param color the color of the line
     * @param size  the size of the line
     */
    public void paintLine(int x1, int y1, int x2, int y2, Color color, int size) {
        Graphics2D g2 = canvasImage.createGraphics();
        g2.setColor(color);
        Composite c = g2.getComposite();
        if (color.getAlpha() == 0) {
            g2.setComposite(AlphaComposite.Clear);
        }

        // Bresenham's line algorithm
        int dx = Math.abs(x2 - x1);
        int dy = Math.abs(y2 - y1);
        int sx = x1 < x2 ? 1 : -1;
        int sy = y1 < y2 ? 1 : -1;
        int err = dx - dy;

        while (true) {
            g2.fillRect(x1, y1, size, size);

            if (x1 == x2 && y1 == y2) break;
            int e2 = 2 * err;
            if (e2 > -dy) {
                err -= dy;
                x1 += sx;
            }
            if (e2 < dx) {
                err += dx;
                y1 += sy;
            }
        }
        g2.setComposite(c);
        g2.dispose();
    }

    /**
     * Draws the canvas image onto the provided Graphics2D object.
     *
     * @param g2 the Graphics2D object to draw on
     */
    public void draw(Graphics2D g2) {
        g2.drawImage(canvasImage, 0, 0, null);
    }
}
