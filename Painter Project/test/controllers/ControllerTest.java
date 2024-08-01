package interface_adapter;

import app.View;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class ControllerTest {
    private Controller controller;
    private View view;

    @Before
    public void setUp() {
        view = mock(View.class);
        controller = new Controller(view);
    }

    @Test
    public void testControllerInitialization() {
        assertNotNull(controller.mouse);
        assertNotNull(controller.keyboard);
    }

    @Test
    public void testMouseIntegration() {
        assertNotNull(controller.mouse);
    }

    @Test
    public void testKeyboardIntegration() {
        assertNotNull(controller.keyboard);
    }
}
