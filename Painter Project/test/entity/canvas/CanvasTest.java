package entity.canvas;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.awt.*;
import java.awt.image.BufferedImage;

import static org.junit.jupiter.api.Assertions.*;

public class CanvasTest {

    private Canvas canvas;

    @BeforeEach
    public void setUp() {
        canvas = new Canvas(100, 100);
    }

    @Test
    public void testClearCanvas() {
        canvas.clearCanvas();
        BufferedImage img = canvas.getCanvasImage();
        int rgb = img.getRGB(0, 0);
        assertEquals(0, rgb, "Canvas should be cleared to transparent");
    }

    @Test
    public void testGetCanvasImage() {
        assertNotNull(canvas.getCanvasImage(), "Canvas image should not be null");
        assertEquals(100, canvas.getCanvasImage().getWidth(), "Canvas width should be 100");
        assertEquals(100, canvas.getCanvasImage().getHeight(), "Canvas height should be 100");
    }

    @Test
    public void testPaintArea() {
        canvas.paintArea(10, 10, Color.BLACK, 10);
        BufferedImage img = canvas.getCanvasImage();
        int rgb = img.getRGB(15, 15);
        assertEquals(Color.BLACK.getRGB(), rgb, "Pixel should be painted black");
    }

    @Test
    public void testPaintLine() {
        canvas.paintLine(10, 10, 20, 20, Color.BLACK, 1);
        BufferedImage img = canvas.getCanvasImage();
        int rgb = img.getRGB(15, 15);
        assertEquals(Color.BLACK.getRGB(), rgb, "Pixel should be painted black");
    }

    @Test
    public void testDraw() {
        BufferedImage img = new BufferedImage(100, 100, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = img.createGraphics();
        canvas.draw(g2);
        g2.dispose();
        assertNotNull(img, "Image should not be null after drawing");
    }
}
