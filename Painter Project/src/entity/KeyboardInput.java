package entity;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import canvas.CanvasManager;

public class KeyboardInput implements KeyListener {
    private int lastTyped;
    private int lastPressed;
    private int lastReleased;
    private CanvasManager canvasManager;

    public KeyboardInput(CanvasManager input) {
        lastTyped = -1;
        lastPressed = -1;
        lastReleased = -1;
        canvasManager = input;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        lastTyped = e.getKeyCode();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        lastPressed = e.getKeyCode();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        lastReleased = e.getKeyCode();

        if (lastReleased == 83) {
            canvasManager.exportToPNG();
        }
    }

    public int getLastTyped() {
        return lastTyped;
    }

    public int getLastPressed() {
        return lastPressed;
    }

    public int getLastReleased() {
        return lastReleased;
    }
}
