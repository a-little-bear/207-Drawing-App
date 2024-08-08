package data_access.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class GoogleGeminiMathAPITest {

    private GoogleGeminiMathAPI mathAPI;

    @BeforeEach
    void setUp() {
        mathAPI = spy(new GoogleGeminiMathAPI());
    }

    @Test
    void testSolveEquation() throws IOException {
        String latex = "x^2 + y^2 = z^2";
        String expectedResult = "Steps to solve the equation";

        doReturn(expectedResult).when(mathAPI).getResponse(anyString());

        String result = mathAPI.solveEquation(latex);
        assertEquals(expectedResult, result, "The solveEquation method should return the correct result");
    }
}
