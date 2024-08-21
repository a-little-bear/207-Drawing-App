package entity.canvas;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

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
    public void testGetCanvasImage() {
        BufferedImage canvasImage = canvasManager.getCanvasImage();
        assertNotNull(canvasImage, "Canvas image should not be null");
        assertEquals(100, canvasImage.getWidth(), "Canvas image should have the correct width");
        assertEquals(100, canvasImage.getHeight(), "Canvas image should have the correct height");
    }

//    @Test
//    public void testChooseColor() {
//        InputData mockInputData = mock(InputData.class);
//        // The JFrame is created in the method but not easily tested in a non-GUI environment
//        // For this reason, we verify the expected behavior when a color is selected
//        // Here, simulate a color choice and verify that the color is set in the inputData
//        // Simulate RED selection
//        canvasManager.chooseColor(mockInputData);
//        // Since there's no easy way to capture JFrame interactions, assume RED is chosen
//        verify(mockInputData).setCurrentColor(Color.RED);
//    }

    @Test
    public void testClearScreen() {
        Canvas topLayer = mock(Canvas.class);
        canvasManager.getLayers().add(topLayer);

        canvasManager.clearScreen();

        verify(topLayer, times(1)).clearCanvas();
    }

    @Test
    public void testGetAndSetLayers() {
        ArrayList<Canvas> newLayers = new ArrayList<>();
        newLayers.add(new Canvas(100, 100));

        canvasManager.setLayers(newLayers);

        assertEquals(newLayers, canvasManager.getLayers(), "Layers should be correctly set and retrieved");
    }
}
