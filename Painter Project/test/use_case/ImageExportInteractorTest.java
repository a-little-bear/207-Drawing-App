package use_case;

import data_access.DataAccessObject;
import entity.canvas.CanvasManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

import static org.mockito.Mockito.*;

public class ImageExportInteractorTest {

    private ImageExportInteractor imageExportInteractor;
    private DataAccessObject mockDataAccessObject;
    private CanvasManager mockCanvasManager;

    @BeforeEach
    void setUp() {
        mockDataAccessObject = mock(DataAccessObject.class);
        imageExportInteractor = new ImageExportInteractor(mockDataAccessObject);
        mockCanvasManager = mock(CanvasManager.class);
    }

    @Test
    void testSaveImage() {
        BufferedImage image = new BufferedImage(100, 100, BufferedImage.TYPE_INT_ARGB);
        when(mockCanvasManager.getCanvasImage()).thenReturn(image);

        imageExportInteractor.saveImage(mockCanvasManager);
        verify(mockDataAccessObject, times(1)).saveFile(anyString(), eq(image));
    }

    @Test
    void testExportCanvasManager() {
        imageExportInteractor.exportCanvasManager(mockCanvasManager);
        verify(mockDataAccessObject, times(1)).exportFile(anyString(),any(ArrayList.class));
    }
}
