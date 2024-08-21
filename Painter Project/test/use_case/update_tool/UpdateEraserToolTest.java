package use_case.update_tool;

import entity.canvas.CanvasManager;
import entity.tool.EraserTool;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case.InputBoundary;
import use_case.InputData;

import java.awt.Color;

import static org.mockito.Mockito.*;

class UpdateEraserToolTest {
    private UpdateEraserTool updateEraserTool;
    private EraserTool mockEraserTool;
    private InputData mockInputData;
    private InputBoundary mockInteractor;
    private CanvasManager mockCanvasManager;

    @BeforeEach
    void setUp() {
        updateEraserTool = new UpdateEraserTool();
        mockEraserTool = mock(EraserTool.class);
        mockInputData = mock(InputData.class);
        mockInteractor = mock(InputBoundary.class);
        mockCanvasManager = mock(CanvasManager.class);

        when(mockInteractor.getCanvasManager()).thenReturn(mockCanvasManager);
        when(mockEraserTool.getColor()).thenReturn(Color.WHITE); // Set the color to white explicitly
        when(mockEraserTool.getSize()).thenReturn(0); // Assuming size is zero for simplicity
    }

    @Test
    void update() {
        // Simulating mouse coordinates
        when(mockInputData.getXCoord()).thenReturn(10);
        when(mockInputData.getYCoord()).thenReturn(10);
        when(mockInputData.getLastXCoord()).thenReturn(5);
        when(mockInputData.getLastYCoord()).thenReturn(5);
        when(mockInputData.getMouseIsActive()).thenReturn(true);

        updateEraserTool.update(mockEraserTool, mockInputData, mockInteractor);

        // Verify the call with the expected color and size
        verify(mockCanvasManager).paintLine(5, 5, 10, 10, Color.WHITE, 0);
    }
}
