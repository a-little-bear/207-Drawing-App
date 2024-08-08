package interface_adapter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import use_case.OutputData;

import static org.mockito.Mockito.verify;

public class PresenterTest {

    private Presenter presenter;
    private ViewModel viewModel;
    private OutputData outputData;

    @BeforeEach
    void setUp() {
        viewModel = Mockito.mock(ViewModel.class);
        outputData = Mockito.mock(OutputData.class);
        presenter = new Presenter(viewModel, outputData);
    }

    @Test
    void testUpdateCanvasManager() {
        presenter.updateCanvasManager();
        verify(viewModel).setCanvasManager(outputData.getCanvasManager());
    }

    @Test
    void testUpdateCurrentTool() {
        presenter.updateCurrentTool();
        verify(viewModel).setCurrentTool(outputData.getCurrentTool());
    }

    @Test
    void testUpdateCurrentColor() {
        presenter.updateCurrentColor();
        verify(viewModel).setActiveColor(outputData.getCurrentColor());
    }
}
