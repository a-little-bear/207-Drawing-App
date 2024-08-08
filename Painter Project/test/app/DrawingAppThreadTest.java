//package app;
//
//import interface_adapter.Controller;
//import use_case.OutputBoundary;
//import view.View;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mockito;
//
//import static org.junit.jupiter.api.Assertions.assertFalse;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//import static org.mockito.Mockito.mock;
//
//public class DrawingAppThreadTest {
//    private DrawingAppThread drawingAppThread;
//    private View mockView;
//    private Controller mockController;
//    private OutputBoundary mockOutputBoundary;
//    private Thread mockThread;
//
//    @BeforeEach
//    void setUp() {
//        mockView = mock(View.class);
//        mockController = mock(Controller.class);
//        mockOutputBoundary = mock(OutputBoundary.class);
//        mockThread = Mockito.spy(new Thread(() -> {}));
//        drawingAppThread = new DrawingAppThread(mockView, mockController, mockOutputBoundary, mockThread);
//    }
//
//    @Test
//    void testThreadLifecycle() throws InterruptedException {
//        drawingAppThread.startThread();
//        Mockito.verify(mockThread).start();
//
//        mockThread.start();
//        Thread.sleep(50); // Allow some time for the thread to run
//
//        assertTrue(mockThread.isAlive());
//        mockThread.interrupt();
//        Thread.sleep(50); // Allow some time for the interrupt to process
//
//        assertFalse(mockThread.isAlive() || mockThread.isInterrupted());
//    }
//}
