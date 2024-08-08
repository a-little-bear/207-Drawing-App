package use_case;

import data_access.DataAccessObject;
import entity.canvas.CanvasManager;
import view.View;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.image.BufferedImage;

import static org.mockito.Mockito.*;

public class ImageExportInteractorTest {

    private ImageExportInteractor interactor;
    private DataAccessObject mockDataAccessObject;
    private View mockView;

    @BeforeEach
    public void setUp() {
        mockDataAccessObject = mock(DataAccessObject.class);
        mockView = mock(View.class);
        interactor = new ImageExportInteractor(mockDataAccessObject);
    }

    @Test
    public void testExportImage() {
        BufferedImage mockImage = new BufferedImage(100, 100, BufferedImage.TYPE_INT_ARGB);

        // Mock the canvasManager and its method
        CanvasManager mockCanvasManager = mock(CanvasManager.class);

        // Run the exportImage method
        interactor.saveImage(mockCanvasManager);

        // Verify the interaction
        verify(mockDataAccessObject).saveFile("Specify a file to save", mockImage);
    }
}
