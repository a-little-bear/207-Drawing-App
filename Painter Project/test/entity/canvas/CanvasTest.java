package entity.canvas;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;

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
        for (int x = 0; x < img.getWidth(); x++) {
            for (int y = 0; y < img.getHeight(); y++) {
                int rgb = img.getRGB(x, y);
                assertEquals(0, rgb, "Canvas should be cleared to transparent");
            }
        }
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

    @Test
    public void testSerialization() throws IOException, ClassNotFoundException {
        // Paint something on the canvas to ensure there's content to serialize
        canvas.paintArea(10, 10, Color.BLUE, 20);

        // Serialize the canvas
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(canvas);
        oos.close();

        // Deserialize the canvas
        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bais);
        Canvas deserializedCanvas = (Canvas) ois.readObject();
        ois.close();

        // Validate that the deserialized canvas has the same properties as the original
        assertNotNull(deserializedCanvas, "Deserialized canvas should not be null");
        BufferedImage originalImage = canvas.getCanvasImage();
        BufferedImage deserializedImage = deserializedCanvas.getCanvasImage();

        assertEquals(originalImage.getWidth(), deserializedImage.getWidth(), "Width should match after deserialization");
        assertEquals(originalImage.getHeight(), deserializedImage.getHeight(), "Height should match after deserialization");

        // Check that the content is the same
        for (int x = 0; x < originalImage.getWidth(); x++) {
            for (int y = 0; y < originalImage.getHeight(); y++) {
                assertEquals(originalImage.getRGB(x, y), deserializedImage.getRGB(x, y),
                        "Pixel content should match after deserialization");
            }
        }
    }

    @Test
    public void testSerializationEmptyCanvas() throws IOException, ClassNotFoundException {
        // Ensure the canvas is clear
        canvas.clearCanvas();

        // Serialize the canvas
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(canvas);
        oos.close();

        // Deserialize the canvas
        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bais);
        Canvas deserializedCanvas = (Canvas) ois.readObject();
        ois.close();

        // Validate that the deserialized canvas has the same properties as the original
        assertNotNull(deserializedCanvas, "Deserialized canvas should not be null");
        BufferedImage originalImage = canvas.getCanvasImage();
        BufferedImage deserializedImage = deserializedCanvas.getCanvasImage();

        assertEquals(originalImage.getWidth(), deserializedImage.getWidth(), "Width should match after deserialization");
        assertEquals(originalImage.getHeight(), deserializedImage.getHeight(), "Height should match after deserialization");

        // Check that the content is the same
        for (int x = 0; x < originalImage.getWidth(); x++) {
            for (int y = 0; y < originalImage.getHeight(); y++) {
                assertEquals(originalImage.getRGB(x, y), deserializedImage.getRGB(x, y),
                        "Pixel content should match after deserialization");
            }
        }
    }
}
