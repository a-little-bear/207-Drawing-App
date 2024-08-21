package data_access.api;

import org.junit.jupiter.api.Test;

import java.awt.image.BufferedImage;

import static org.junit.jupiter.api.Assertions.*;

public class SimpleTexLatexAPITest {

    private final SimpleTexLatexAPI simpleTexLatexAPI = new SimpleTexLatexAPI();

    @Test
    void testOCR_SuccessfulResponse() {
        // Assuming the API key and API are functional
        BufferedImage image = new BufferedImage(100, 100, BufferedImage.TYPE_INT_ARGB);
        String latex = simpleTexLatexAPI.OCR(image);

        // Basic assertions to ensure it works
        assertNotNull(latex, "OCR should return a result");
        assertFalse(latex.isEmpty(), "OCR result should not be empty");
    }
}
