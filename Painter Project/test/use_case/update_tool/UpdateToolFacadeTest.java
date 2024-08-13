package use_case.update_tool;

import entity.canvas.Canvas;
import entity.canvas.CanvasManager;
import entity.tool.EraserTool;
import entity.tool.FillTool;
import entity.tool.PaintTool;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case.InputBoundary;
import use_case.InputData;

import java.awt.*;
import java.awt.image.BufferedImage;

import static org.mockito.Mockito.*;

public class UpdateToolFacadeTest {

    private InputBoundary mockInputBoundary;
    private InputData mockInputData;
    private CanvasManager mockCanvasManager;
    private Canvas mockCanvas;
    private BufferedImage mockBufferedImage;

    @BeforeEach
    void setUp() {
        mockInputBoundary = mock(InputBoundary.class);
        mockInputData = mock(InputData.class);
        mockCanvasManager = mock(CanvasManager.class);
        mockCanvas = mock(Canvas.class);
        mockBufferedImage = mock(BufferedImage.class);

        // Ensure the mock InputBoundary returns a mock CanvasManager
        when(mockInputBoundary.getCanvasManager()).thenReturn(mockCanvasManager);

        // Ensure the CanvasManager returns a mock Canvas
        when(mockCanvasManager.getTopLayer()).thenReturn(mockCanvas);

        // Ensure the Canvas returns a non-null BufferedImage
        when(mockCanvas.getCanvasImage()).thenReturn(mockBufferedImage);

        // Mock BufferedImage behavior to avoid NullPointerException
        when(mockBufferedImage.getRGB(anyInt(), anyInt())).thenReturn(Color.WHITE.getRGB());

        // Mock the current color for the EraserTool to be white
        when(mockInputBoundary.getCurrentColor()).thenReturn(Color.WHITE);
    }

    @Test
    void testUpdatePaintTool() {
        PaintTool paintTool = mock(PaintTool.class);
        when(mockInputData.getMouseIsActive()).thenReturn(true);
        when(mockInputBoundary.getCurrentColor()).thenReturn(Color.BLACK);

        UpdateToolFacade.update(paintTool, mockInputData, mockInputBoundary);

        // Verify interactions with CanvasManager and InputBoundary
        verify(mockInputBoundary, times(1)).getCurrentColor();
        verify(mockCanvasManager, times(1)).paintLine(anyInt(), anyInt(), anyInt(), anyInt(), eq(Color.BLACK), anyInt());
    }

//    @Test
//    void testUpdateEraserTool() {
//        EraserTool eraserTool = mock(EraserTool.class);
//        when(mockInputData.getMouseIsActive()).thenReturn(true);
//
//        // Assuming the eraser uses a specific color (like white or transparent)
//        when(mockInputBoundary.getCurrentColor()).thenReturn(Color.WHITE);
//
//        UpdateToolFacade.update(eraserTool, mockInputData, mockInputBoundary);
//
//        // Verify interactions with CanvasManager and ensure the color is white
//        verify(mockCanvasManager, times(1)).paintLine(anyInt(), anyInt(), anyInt(), anyInt(), eq(Color.WHITE), anyInt());
//    }

    @Test
    void testUpdateFillTool() {
        FillTool fillTool = mock(FillTool.class);
        when(mockInputData.getMouseIsActive()).thenReturn(true);

        UpdateToolFacade.update(fillTool, mockInputData, mockInputBoundary);

        // Verify interactions with CanvasManager and Canvas
        verify(mockCanvasManager, times(1)).getTopLayer();
        verify(mockCanvas, times(1)).getCanvasImage();
        verify(mockBufferedImage, times(1)).getRGB(anyInt(), anyInt());
    }
}
