package canvas;

import javax.imageio.ImageIO;
import java.awt.*;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Canvas {
    private BufferedImage canvasImage;
    private int width, height;

    public Canvas(int width, int height) {
        this.width = width;
        this.height = height;
        canvasImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
        clearCanvas();
    }

    public void clearCanvas() {
        Graphics2D g2 = canvasImage.createGraphics();
        g2.setColor(new Color(0,0,0,0));
        g2.fillRect(0, 0, width, height);
        g2.dispose();
    }
    public Graphics2D getCanvasImage() { return canvasImage.createGraphics(); }
    public void paintArea(int x, int y, Color color, int size) {
        Graphics2D g2 = canvasImage.createGraphics();
        g2.setColor(color);
        g2.fillRect(x, y, size, size);
        g2.dispose();
    }

    public void paintLine(int x1, int y1, int x2, int y2, Color color, int size) {
        Graphics2D g2 = canvasImage.createGraphics();
        g2.setColor(color);

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

        g2.dispose();
    }

    public void draw(Graphics2D g2) {
        g2.drawImage(canvasImage, 0, 0, null);
    }

    public void exportToPNG() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Specify a file to save");
        int userSelection = fileChooser.showSaveDialog(null);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();

            if (!file.getAbsolutePath().endsWith(".png")) {
                file = new File(file.getAbsolutePath() + ".png");
            }

            try {
                ImageIO.write(canvasImage, "png", file);
            } catch (IOException | NullPointerException e) {
                e.printStackTrace();
            }
        }
    }
}
