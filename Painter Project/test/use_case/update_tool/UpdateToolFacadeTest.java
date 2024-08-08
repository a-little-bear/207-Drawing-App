package use_case.update_tool;

import entity.tool.EraserTool;
import entity.tool.FillTool;
import entity.tool.PaintTool;
import entity.tool.Tool;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case.InputBoundary;
import use_case.InputData;
import use_case.Interactor;

import static org.mockito.Mockito.*;

public class UpdateToolFacadeTest {

    private UpdateToolFacade updateToolFacade;
    private InputBoundary mockInputBoundary;
    private InputData mockInputData;

    @BeforeEach
    void setUp() {
        mockInputBoundary = mock(InputBoundary.class);
        mockInputData = mock(InputData.class);
    }

    @Test
    void testUpdatePaintTool() {
        PaintTool paintTool = mock(PaintTool.class);
        when(mockInputData.getCurrentTool()).thenReturn(paintTool);

        UpdateToolFacade.update(paintTool, mockInputData, mockInputBoundary);
        verify(mockInputData, times(1)).getCurrentTool();
    }

    @Test
    void testUpdateEraserTool() {
        EraserTool eraserTool = mock(EraserTool.class);
        when(mockInputData.getCurrentTool()).thenReturn(eraserTool);

        UpdateToolFacade.update(eraserTool, mockInputData, mockInputBoundary);
        verify(mockInputData, times(1)).getCurrentTool();
    }

    @Test
    void testUpdateFillTool() {
        FillTool fillTool = mock(FillTool.class);
        when(mockInputData.getCurrentTool()).thenReturn(fillTool);

        UpdateToolFacade.update(fillTool, mockInputData, mockInputBoundary);
        verify(mockInputData, times(1)).getCurrentTool();
    }
}
