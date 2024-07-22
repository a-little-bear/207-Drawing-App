package data_access;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class DataAccessObjectTest {

    private DataAccessObject dataAccessObject;
    private JFileChooser fileChooser;

    @BeforeEach
    public void setUp() {
        fileChooser = mock(JFileChooser.class);
        dataAccessObject = new DataAccessObject(fileChooser);
    }

    @Test
    public void testSaveFile() throws IOException {
        // Create a dummy image
        BufferedImage image = new BufferedImage(100, 100, BufferedImage.TYPE_INT_ARGB);
        String filePath = "test_output.png";
        File testFile = new File(filePath);
        // Using Mockito to mock JFileChooser
        // To avoid opening a dialog box during testing
        when(fileChooser.showSaveDialog(null)).thenReturn(JFileChooser.APPROVE_OPTION);
        when(fileChooser.getSelectedFile()).thenReturn(testFile);

        // Use DataAccessObject to save the image
        dataAccessObject.saveFile("Save File", image);

        // Check if the file exists
        assertTrue(testFile.exists(), "File should be created");

        // Verify the contents
        BufferedImage savedImage = ImageIO.read(testFile);
        assertNotNull(savedImage, "Saved image should not be null");
        assertEquals(image.getWidth(), savedImage.getWidth(), "Image width should match");
        assertEquals(image.getHeight(), savedImage.getHeight(), "Image height should match");

        // Cleanup
        if (testFile.exists()) {
            boolean deleted = testFile.delete();
            if (!deleted) {
                System.err.println("Warning: Failed to delete test output file");
            }
        }
    }
}
