package data_access.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimpleTexLatexAPITest {

    private SimpleTexLatexAPI latexAPI;

    @BeforeEach
    void setUp() {
        latexAPI = new SimpleTexLatexAPI();
    }

    @Test
    void testConvertToLatex() {
        String input = "x^2 + y^2 = z^2";
        String expectedOutput = "\\( x^2 + y^2 = z^2 \\)";

        String result = latexAPI.convertToLatex(input);
        assertEquals(expectedOutput, result, "The convertToLatex method should return the correct LaTeX representation");
    }
}
