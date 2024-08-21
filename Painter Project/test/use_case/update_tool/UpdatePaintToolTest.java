package use_case.update_tool;

import entity.canvas.CanvasManager;
import entity.tool.PaintTool;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case.InputBoundary;
import use_case.InputData;

import java.awt.Color;

import static org.mockito.Mockito.*;

class UpdatePaintToolTest {
    private UpdatePaintTool updatePaintTool;
    private PaintTool mockPaintTool;
    private InputData mockInputData;
    private InputBoundary mockInteractor;

    @BeforeEach
    void setUp() {
        updatePaintTool = new UpdatePaintTool();
        mockPaintTool = mock(PaintTool.class);
        mockInputData = mock(InputData.class);
        mockInteractor = mock(InputBoundary.class);

        when(mockInteractor.getCanvasManager()).thenReturn(mock(CanvasManager.class));
        when(mockInteractor.getCurrentColor()).thenReturn(Color.BLACK); // Ensure this returns a non-null value
        when(mockPaintTool.getSize()).thenReturn(10);
    }

    @Test
    void update() {
        when(mockInputData.getMouseIsActive()).thenReturn(true);
        when(mockInputData.getXCoord()).thenReturn(100);
        when(mockInputData.getYCoord()).thenReturn(150);
        when(mockInputData.getLastXCoord()).thenReturn(95);
        when(mockInputData.getLastYCoord()).thenReturn(145);

        updatePaintTool.update(mockPaintTool, mockInputData, mockInteractor);

        verify(mockInteractor.getCanvasManager()).paintLine(
                95, 145, 100, 150, Color.BLACK, 10);
    }
}
