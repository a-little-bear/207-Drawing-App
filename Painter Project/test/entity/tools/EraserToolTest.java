package entity.tools;

import interface_adapter.Controller;
import app.View;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.awt.*;
import java.awt.image.BufferedImage;

import static org.junit.jupiter.api.Assertions.*;

public class EraserToolTest {

    private View view;
    private Controller controller;
    private EraserTool eraserTool;

    @BeforeEach
    public void setUp() {
        view = new View();
        controller = new Controller(view);
        eraserTool = new EraserTool(view, controller);
    }

    @Test
    public void testUpdate_StartsDrawing() {
        controller.mouse.isActive = true;
        controller.mouse.xCoord = 10;
        controller.mouse.yCoord = 10;

        eraserTool.update();

        BufferedImage canvasImage = view.canvasManager.getTopLayer().getCanvasImage();

        // drawing started at (10, 10)
        assertEquals(Color.WHITE.getRGB(), canvasImage.getRGB(10, 10));
    }

    @ParameterizedTest
    @CsvSource({
            "10, 10, 20, 20",
            "15, 15, 25, 25",
            "0, 0, 30, 30"
    })
    public void testUpdate_ContinuesDrawing(int x1, int y1, int x2, int y2) {
        controller.mouse.isActive = true;
        controller.mouse.xCoord = x1;
        controller.mouse.yCoord = y1;

        eraserTool.update();
        controller.mouse.xCoord = x2;
        controller.mouse.yCoord = y2;
        eraserTool.update();

        BufferedImage canvasImage = view.canvasManager.getTopLayer().getCanvasImage();

        // starting and ending points
        assertEquals(Color.WHITE.getRGB(), canvasImage.getRGB(x1, y1));
        assertEquals(Color.WHITE.getRGB(), canvasImage.getRGB(x2, y2));

        // intermediate points
        verifyLineDrawing(canvasImage, x1, y1, x2, y2);
    }

    @Test
    public void testUpdate_StopsDrawing() {
        controller.mouse.isActive = true;
        controller.mouse.xCoord = 10;
        controller.mouse.yCoord = 10;

        eraserTool.update();
        controller.mouse.isActive = false;
        eraserTool.update();

        // isActive flag is false after stopping drawing
        assertFalse(controller.mouse.isActive);
    }

    @Test
    public void testDraw() {
        BufferedImage image = new BufferedImage(100, 100, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = image.createGraphics();
        controller.mouse.xCoord = 10;
        controller.mouse.yCoord = 10;

        eraserTool.draw(g2);
        g2.dispose();

        // Verify that a rectangle was drawn at the expected position
        assertEquals(Color.WHITE.getRGB(), image.getRGB(10, 10));
    }

    @Test
    public void testIncrementSize() {
        eraserTool.incrementSize(5);
        assertEquals(25, eraserTool.getSize());
        eraserTool.incrementSize(-30);
        assertEquals(1, eraserTool.getSize());
    }

    private void verifyLineDrawing(BufferedImage image, int x1, int y1, int x2, int y2) {
        int dx = Math.abs(x2 - x1);
        int dy = Math.abs(y2 - y1);
        int sx = x1 < x2 ? 1 : -1;
        int sy = y1 < y2 ? 1 : -1;
        int err = dx - dy;

        while (true) {
            assertEquals(Color.WHITE.getRGB(), image.getRGB(x1, y1));
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
    }
}
