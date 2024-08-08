package interface_adapter;

import entity.canvas.CanvasManager;
import entity.tool.PaintTool;
import entity.tool.Tool;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

public class ViewModelTest {

    private ViewModel viewModel;
    private Tool tool;
    private CanvasManager canvasManager;

    @BeforeEach
    void setUp() {
        tool = new PaintTool();
        canvasManager = new CanvasManager(100, 100);
        viewModel = new ViewModel(tool, canvasManager);
    }

    @Test
    void testInitialValues() {
        assertEquals(tool, viewModel.getCurrentTool(), "Initial tool should be set");
        assertEquals(canvasManager, viewModel.getCanvasManager(), "Initial canvas manager should be set");
        assertEquals(Color.BLACK, viewModel.getActiveColor(), "Initial color should be black");
    }

    @Test
    void testSetCurrentTool() {
        Tool newTool = new PaintTool();
        viewModel.setCurrentTool(newTool);
        assertEquals(newTool, viewModel.getCurrentTool(), "Tool should be updated");
    }

    @Test
    void testSetActiveColor() {
        Color newColor = Color.RED;
        viewModel.setActiveColor(newColor);
        assertEquals(newColor, viewModel.getActiveColor(), "Active color should be updated");
    }
}
