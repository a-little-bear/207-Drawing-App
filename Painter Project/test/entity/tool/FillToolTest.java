package entity.tool;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

public class FillToolTest {

    private FillTool fillTool;

    @BeforeEach
    void setUp() {
        fillTool = new FillTool();
        fillTool.setSize(10);
        fillTool.setColor(Color.RED);
    }

    @Test
    void testDefaultValues() {
        FillTool tool = new FillTool();
        assertEquals(0, tool.getSize(), "Initial size should be 0");
        assertNull(tool.getColor(), "Initial color should be null");
    }

    @Test
    void testSetPaintColor() {
        Color newColor = Color.BLUE;
        fillTool.setPaintColor(newColor);
        assertEquals(newColor, fillTool.getColor(), "Color should be set correctly");
    }
}
