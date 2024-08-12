package use_case.draw;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case.InputData;

import java.awt.*;

import static org.mockito.Mockito.*;

class DrawFillTest {
    private DrawFill drawFill;
    private Graphics2D mockGraphics;
    private InputData mockInputData;
    private Color color;

    @BeforeEach
    void setUp() {
        drawFill = new DrawFill();
        mockGraphics = mock(Graphics2D.class);
        mockInputData = mock(InputData.class);
        color = Color.RED;
    }

    @Test
    void draw() {
        when(mockInputData.getXCoord()).thenReturn(10);
        when(mockInputData.getYCoord()).thenReturn(10);

        drawFill.draw(mockGraphics, mockInputData, color);

        verify(mockGraphics, times(1)).setColor(color);
        verify(mockGraphics, times(1)).fillRect(10, 10, 5, 5);
    }
}
