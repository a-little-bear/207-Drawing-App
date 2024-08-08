package entity.tool;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

public class EraserToolTest {

    private EraserTool eraserTool;

    @BeforeEach
    void setUp() {
        eraserTool = new EraserTool();
        eraserTool.setSize(10);
        eraserTool.setColor(Color.WHITE);
    }

    @Test
    void testDefaultValues() {
        EraserTool tool = new EraserTool();
        assertEquals(0, tool.getSize(), "Initial size should be 0");
        assertNull(tool.getColor(), "Initial color should be null");
        assertFalse(tool.isDrawing(), "Initial isDrawing should be false");
    }

    @Test
    void testIncrementSize() {
        eraserTool.setSize(5);
        eraserTool.incrementSize(10);
        assertEquals(15, eraserTool.getSize(), "Size should be incremented correctly");

        eraserTool.incrementSize(-14); // This should set the size to 1, not below 1
        assertEquals(1, eraserTool.getSize(), "Size should not go below 1");
    }

    @Test
    void testSetIsDrawing() {
        assertFalse(eraserTool.isDrawing(), "Initial isDrawing should be false");

        boolean result = eraserTool.setIsDrawing(true);
        assertTrue(result, "setIsDrawing should return the value set");
        assertTrue(eraserTool.isDrawing(), "isDrawing should be true after setting it to true");

        result = eraserTool.setIsDrawing(false);
        assertFalse(result, "setIsDrawing should return the value set");
        assertFalse(eraserTool.isDrawing(), "isDrawing should be false after setting it to false");
    }

    @Test
    void testSetPaintColor() {
        Color newColor = Color.RED;
        eraserTool.setPaintColor(newColor);
        assertEquals(newColor, eraserTool.getColor(), "Color should be set correctly");
    }
}
