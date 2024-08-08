//package app;
//
//import interface_adapter.Controller;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mockito;
//import use_case.OutputBoundary;
//import view.View;
//
//import static org.junit.jupiter.api.Assertions.assertTrue;
//import static org.mockito.Mockito.mock;
//
//public class DrawingAppThreadTest {
//    private DrawingAppThread drawingAppThread;
//    private View mockView;
//    private Controller mockController;
//    private OutputBoundary mockOutputBoundary;
//
//    @BeforeEach
//    void setUp() {
//        mockView = mock(View.class);
//        mockController = mock(Controller.class);
//        mockOutputBoundary = mock(OutputBoundary.class);
//        drawingAppThread = new DrawingAppThread(mockView, mockController, mockOutputBoundary);
//    }
//
//    @Test
//    void testThreadStarts() throws InterruptedException {
//        Thread thread = drawingAppThread.getThread();
//        assertTrue(thread.isAlive(), "Thread should be alive after starting");
//
//        thread.interrupt();
//        thread.join(50); // Allow some time for the interrupt to process
//        assertTrue(thread.isInterrupted(), "Thread should be interrupted");
//    }
//}
