package entity.canvas;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

/**
 * The Canvas class provides functionality for drawing and manipulating a canvas.
 */
public class Canvas implements Serializable {
    private transient BufferedImage canvasImage;
    private final int width;
    private final int height;

    /**
     * Instantiates a new Canvas with the specified width and height.
     * The canvas is initialized with a transparent background.
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
     * This image contains all the drawings and modifications made to the canvas.
     *
     * @return The current image of the canvas.
     */
    public BufferedImage getCanvasImage() {
        return canvasImage;
    }

    /**
     * Paints a filled rectangle at the specified location on the canvas.
     * The rectangle is drawn with the specified color and size.
     *
     * @param x     The x coordinate of the rectangle.
     * @param y     The y coordinate of the rectangle.
     * @param color The color of the rectangle.
     * @param size  The size of the rectangle (width and height).
     */
    public void paintArea(int x, int y, Color color, int size) {
        Graphics2D g2 = canvasImage.createGraphics();
        g2.setColor(color);
        g2.fillRect(x, y, size, size);
        g2.dispose();
    }

    /**
     * Paints a line between two points on the canvas using Bresenham's line algorithm.
     * The line is drawn with the specified color and thickness.
     *
     * @param x1    The starting x coordinate of the line.
     * @param y1    The starting y coordinate of the line.
     * @param x2    The ending x coordinate of the line.
     * @param y2    The ending y coordinate of the line.
     * @param color The color of the line.
     * @param size  The thickness of the line.
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

    /**
     * Custom serialization method for writing the Canvas object to an output stream.
     * This method handles the serialization of the canvas image.
     *
     * @param out The ObjectOutputStream to write to.
     * @throws IOException If an I/O error occurs while writing the object.
     */
    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        if (canvasImage != null) {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(canvasImage, "png", baos);
            byte[] imageBytes = baos.toByteArray();
            out.writeInt(imageBytes.length);
            out.write(imageBytes);
        } else {
            out.writeInt(0);
        }
    }

    /**
     * Custom deserialization method for reading the Canvas object from an input stream.
     * This method handles the deserialization of the canvas image.
     *
     * @param in The ObjectInputStream to read from.
     * @throws IOException If an I/O error occurs while reading the object.
     * @throws ClassNotFoundException If the class of a serialized object cannot be found.
     */
    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        int length = in.readInt();
        if (length > 0) {
            byte[] imageBytes = new byte[length];
            in.readFully(imageBytes);
            ByteArrayInputStream bais = new ByteArrayInputStream(imageBytes);
            canvasImage = ImageIO.read(bais);
        } else {
            canvasImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
            clearCanvas();
        }
    }
}
