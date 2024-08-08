package view;

import entity.canvas.CanvasManager;
import entity.tool.PaintTool;
import entity.tool.Tool;
import interface_adapter.ViewModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.swing.*;
import java.awt.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class ViewTest {

    private ViewModel viewModel;
    private Tool tool;
    private CanvasManager canvasManager;
    private View view;

    @BeforeEach
    void setUp() {
        tool = new PaintTool();
        canvasManager = new CanvasManager(100, 100);
        viewModel = spy(new ViewModel(tool, canvasManager));
        view = new View(viewModel);
    }

//    @Test
//    void testPaintComponent() {
//        Graphics2D mockGraphics = mock(Graphics2D.class);
//        view.paintComponent(mockGraphics);
//
//        verify(viewModel, times(1)).paint(mockGraphics);
//    }

    @Test
    void testUpdate() {
        view.update();

        assertEquals(viewModel.getDimension(), view.getPreferredSize());
        assertEquals(viewModel.getBackgroundColor(), view.getBackground());
        assertTrue(view.isDoubleBuffered());
    }

    @Test
    void testInitialSetup() {
        assertEquals(viewModel.getDimension(), view.getPreferredSize());
        assertEquals(viewModel.getBackgroundColor(), view.getBackground());
        assertTrue(view.isDoubleBuffered());
    }
}
