package use_case.draw;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import use_case.InputData;

import java.awt.*;

import static org.mockito.Mockito.*;

class DrawPaintTest {
    private DrawPaint drawPaint;
    private Graphics2D mockGraphics;
    private InputData mockInputData;
    private Color color;

    @BeforeEach
    void setUp() {
        drawPaint = new DrawPaint();
        mockGraphics = mock(Graphics2D.class);
        mockInputData = mock(InputData.class);
        color = Color.BLACK;
    }

    @Test
    void draw() {
        when(mockInputData.getXCoord()).thenReturn(10);
        when(mockInputData.getYCoord()).thenReturn(10);

        drawPaint.draw(mockGraphics, mockInputData, color);

        verify(mockGraphics, times(1)).setColor(color);
        verify(mockGraphics, times(1)).fillRect(10, 10, 5, 5);
    }
}
