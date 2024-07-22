package entity.canvas;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.awt.image.BufferedImage;

import static org.junit.jupiter.api.Assertions.*;

public class CanvasManagerTest {

    private CanvasManager canvasManager;

    @BeforeEach
    public void setUp() {
        canvasManager = new CanvasManager(100, 100);
    }

    @Test
    public void testAddLayer() {
        int initialLayerCount = canvasManager.getLayers().size();
        canvasManager.addLayer();
        assertEquals(initialLayerCount + 1, canvasManager.getLayers().size(), "Layer count should increase by 1");
    }

    @Test
    public void testGetTopLayer() {
        Canvas topLayer = canvasManager.getTopLayer();
        assertNotNull(topLayer, "Top layer should not be null");
    }

    @Test
    public void testPaint() {
        canvasManager.paint(10, 10, Color.BLACK, 10);
        BufferedImage img = canvasManager.getTopLayer().getCanvasImage();
        int rgb = img.getRGB(15, 15);
        assertEquals(Color.BLACK.getRGB(), rgb, "Pixel should be painted black");
    }

    @Test
    public void testPaintLine() {
        canvasManager.paintLine(10, 10, 20, 20, Color.BLACK, 1);
        BufferedImage img = canvasManager.getTopLayer().getCanvasImage();
        int rgb = img.getRGB(15, 15);
        assertEquals(Color.BLACK.getRGB(), rgb, "Pixel should be painted black");
    }

    @Test
    public void testDraw() {
        BufferedImage img = new BufferedImage(100, 100, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = img.createGraphics();
        canvasManager.draw(g2);
        g2.dispose();
        assertNotNull(img, "Image should not be null after drawing");
    }

    @Test
    public void testCollapseLayers() {
        Canvas collapsedCanvas = canvasManager.collapseLayers();
        assertNotNull(collapsedCanvas, "Collapsed canvas should not be null");
    }

    @Test
    public void testLatexOCR() {
        // As with CanvasTest, you might want to mock the OCR method in a real-world scenario
        try {
            canvasManager.LatexOCR();
        } catch (Exception e) {
            fail("LatexOCR method should not throw an exception");
        }
    }
}
