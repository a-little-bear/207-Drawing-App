package interface_adapter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.event.MouseEvent;

import static org.junit.jupiter.api.Assertions.*;

public class MouseTest {

    private Mouse mouse;

    @BeforeEach
    void setUp() {
        mouse = new Mouse();
    }

    @Test
    void testMousePressed() {
        MouseEvent e = new MouseEvent(new java.awt.Button(), 0, 0, 0, 10, 10, 1, false, MouseEvent.BUTTON1);
        mouse.mousePressed(e);
        assertTrue(mouse.isActive);
    }

    @Test
    void testMouseReleased() {
        MouseEvent e = new MouseEvent(new java.awt.Button(), 0, 0, 0, 10, 10, 1, false, MouseEvent.BUTTON1);
        mouse.mousePressed(e);
        mouse.mouseReleased(e);
        assertFalse(mouse.isActive);
    }

    @Test
    void testMouseMoved() {
        MouseEvent e = new MouseEvent(new java.awt.Button(), 0, 0, 0, 20, 20, 0, false);
        mouse.mouseMoved(e);
        assertEquals(20, mouse.xCoord);
        assertEquals(20, mouse.yCoord);
    }
}
