package view;

import interface_adapter.ViewModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.awt.*;

import static org.mockito.Mockito.verify;

public class ViewTest {

    private View view;
    private ViewModel viewModel;

    @BeforeEach
    void setUp() {
        viewModel = Mockito.mock(ViewModel.class);
        view = new View(viewModel);
    }

    @Test
    void testPaintComponent() {
        Graphics2D g2 = Mockito.mock(Graphics2D.class);
        view.paintComponent(g2);
        verify(viewModel).paint(g2);
    }
}
