package data_access.api;

import org.junit.Before;
import org.junit.Test;

import java.awt.image.BufferedImage;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;

public class LatexAPITest {
    private LatexAPI latexAPI;
    private final BufferedImage dummyCanvas = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);

    @Before
    public void setUp() {
        latexAPI = new SimpleTexLatexAPI(); // Initialize latexAPI
    }

    @Test
    public void test() {
        assertThat(latexAPI.OCR(dummyCanvas), instanceOf(String.class));
    }
}
