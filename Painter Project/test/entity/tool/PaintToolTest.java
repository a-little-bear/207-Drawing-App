package entity.tool;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

public class PaintToolTest {

    private PaintTool paintTool;

    @BeforeEach
    void setUp() {
        paintTool = new PaintTool();
        paintTool.setSize(10);
        paintTool.setPaintColor(Color.BLACK);
    }

    @Test
    void testDefaultValues() {
        PaintTool tool = new PaintTool();
        assertEquals(0, tool.getSize(), "Initial size should be 0");
        assertNull(tool.getPaintColor(), "Initial color should be null");
        assertFalse(tool.isDrawing(), "Initial isDrawing should be false");
    }

    @Test
    void testIncrementSize() {
        paintTool.setSize(5);
        paintTool.incrementSize(10);
        assertEquals(15, paintTool.getSize(), "Size should be incremented correctly");

        paintTool.incrementSize(-14); // should set the size to 1, not below 1
        assertEquals(1, paintTool.getSize(), "Size should not go below 1");
    }

    @Test
    void testSetIsDrawing() {
        assertFalse(paintTool.isDrawing(), "Initial isDrawing should be false");

        boolean result = paintTool.setIsDrawing(true);
        assertTrue(result, "setIsDrawing should return the value set");
        assertTrue(paintTool.isDrawing(), "isDrawing should be true after setting it to true");

        result = paintTool.setIsDrawing(false);
        assertFalse(result, "setIsDrawing should return the value set");
        assertFalse(paintTool.isDrawing(), "isDrawing should be false after setting it to false");
    }

    @Test
    void testSetPaintColor() {
        Color newColor = Color.RED;
        paintTool.setPaintColor(newColor);
        assertEquals(newColor, paintTool.getPaintColor(), "Color should be set correctly");
    }
}
