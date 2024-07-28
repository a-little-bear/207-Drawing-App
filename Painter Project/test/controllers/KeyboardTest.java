package controllers;

import main.View;
import org.junit.Before;
import org.junit.Test;

import java.awt.event.KeyEvent;

import static org.mockito.Mockito.*;

import entity.canvas.CanvasManager;

public class KeyboardTest {
    private Keyboard keyboard;
    private View view;

    @Before
    public void setUp() {
        view = mock(View.class);
        CanvasManager canvasManager = mock(CanvasManager.class);

        view.canvasManager = canvasManager;
        keyboard = new Keyboard(view);
    }

    @Test
    public void testKeyTyped() {
        KeyEvent event = mock(KeyEvent.class);
        when(event.getKeyCode()).thenReturn(KeyEvent.VK_A);

        keyboard.keyTyped(event);

        assertEquals(KeyEvent.VK_A, keyboard.getLastTyped());
    }

    @Test
    public void testKeyPressed() {
        KeyEvent event = mock(KeyEvent.class);
        when(event.getKeyCode()).thenReturn(KeyEvent.VK_A);

        keyboard.keyPressed(event);

        assertEquals(KeyEvent.VK_A, keyboard.getLastPressed());
    }

    @Test
    public void testKeyReleased() {
        KeyEvent event = mock(KeyEvent.class);
        when(event.getKeyCode()).thenReturn(KeyEvent.VK_A);

        keyboard.keyReleased(event);

        assertEquals(KeyEvent.VK_A, keyboard.getLastReleased());
    }
}
