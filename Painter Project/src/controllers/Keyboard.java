package controllers;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keyboard implements KeyListener {
    private int lastTyped, lastPressed, lastReleased;

    public Keyboard() {

    }

    @Override
    public void keyTyped(KeyEvent e) {
        this.lastTyped = e.getKeyCode();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        this.lastPressed = e.getKeyCode();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        this.lastReleased = e.getKeyCode();
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
