package controllers;

import main.View;
import org.junit.Before;
import org.junit.Test;

import java.awt.event.MouseEvent;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class MouseTest {
    private Mouse mouse;
    private View view;

    @Before
    public void setUp() {
        view = mock(View.class);
        mouse = new Mouse(view);
    }

    @Test
    public void testMousePressed() {
        MouseEvent event = mock(MouseEvent.class);
        when(event.getButton()).thenReturn(MouseEvent.BUTTON1);
        when(event.getX()).thenReturn(100);
        when(event.getY()).thenReturn(200);

        mouse.mousePressed(event);

        assertTrue(mouse.isActive);
        assertEquals(100, mouse.xCoord);
        assertEquals(200, mouse.yCoord);
    }

    @Test
    public void testMouseReleased() {
        MouseEvent event = mock(MouseEvent.class);
        when(event.getButton()).thenReturn(MouseEvent.BUTTON1);

        mouse.mousePressed(event);  // Activate mouse
        mouse.mouseReleased(event); // Deactivate mouse

        assertFalse(mouse.isActive);
    }

    @Test
    public void testMouseMoved() {
        MouseEvent event = mock(MouseEvent.class);
        when(event.getX()).thenReturn(150);
        when(event.getY()).thenReturn(250);

        mouse.mouseMoved(event);

        assertEquals(150, mouse.xCoord);
        assertEquals(250, mouse.yCoord);
    }
}
