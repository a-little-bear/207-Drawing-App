package interface_adapter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import use_case.InputBoundary;
import use_case.InputData;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;

public class ControllerTest {

    private Controller controller;
    private InputBoundary interactor;
    private InputData inputData;
    private Mouse mouse;

    @BeforeEach
    void setUp() {
        interactor = Mockito.mock(InputBoundary.class);
        inputData = Mockito.mock(InputData.class);
        mouse = new Mouse();
        controller = new Controller(interactor, inputData, mouse);
    }

    @Test
    void testControllerInitialization() {
        assertNotNull(controller.getMouse(), "Mouse should be initialized");
    }

    @Test
    void testUpdate() {
        controller.update();
        verify(inputData).updateMouse(mouse);
        verify(interactor).update();
    }
}
