package controllers;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import main.View;
import use_cases.ImageExportInteractor;

public class Keyboard implements KeyListener {
    private int lastTyped, lastPressed, lastReleased;
    private ImageExportInteractor imageExportInteractor;
    private View view;

    public Keyboard(View view) {
        this.view = view;

        this.imageExportInteractor = new ImageExportInteractor();
    }

    @Override
    public void keyTyped(KeyEvent e) {
        this.lastTyped = e.getKeyCode();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        this.lastPressed = e.getKeyCode();

        System.out.println(e.getKeyCode());

        switch (e.getKeyCode()) {
            case 83:    //Save "s"
                imageExportInteractor.exportImage(this.view);
        }
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
