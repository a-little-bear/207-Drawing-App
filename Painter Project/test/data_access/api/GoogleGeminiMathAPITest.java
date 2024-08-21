package data_access.api;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class GoogleGeminiMathAPITest {

    private GoogleGeminiMathAPI mathAPI;

    @BeforeEach
    void setUp() {
        mathAPI = spy(new GoogleGeminiMathAPI());
    }

    @Test
    void testSolveEquation() throws Exception {
        String latex = "x^2 + y^2 = z^2";
        String expectedResult = "Steps to solve the equation";
        GoogleGeminiMathAPI mathAPI = new GoogleGeminiMathAPI();

        Method method = GoogleGeminiMathAPI.class.getDeclaredMethod("getResponse", String.class);
        method.setAccessible(true);
        String result = (String) method.invoke(mathAPI, latex);

        assertEquals(expectedResult, result);
    }

}
