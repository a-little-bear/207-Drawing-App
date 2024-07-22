package controllers;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import entity.tools.EraserTool;
import entity.tools.FillTool;
import entity.tools.PaintTool;
import main.View;
import use_cases.ImageExportInteractor;

public class Keyboard implements KeyListener {
    private int lastPressed, lastReleased;
    private char lastTyped;
    private final ImageExportInteractor imageExportInteractor;
    private final View view;
    private final FillTool fillTool;

    public Keyboard(View view) {
        this.view = view;
        this.fillTool = new FillTool(view, view.getController());
        this.imageExportInteractor = new ImageExportInteractor();
    }

    @Override
    public void keyTyped(KeyEvent e) {
        this.lastTyped = Character.toLowerCase(e.getKeyChar());
        switch (this.lastTyped) {
            case 'e':
                imageExportInteractor.exportImage(view);
            case 's':
                imageExportInteractor.exportImage(view);
            case 'q':
                view.currentTool = new PaintTool(view,  view.getController());
            case 'w':
                view.currentTool = new EraserTool(view, view.getController());
            case 't':
                // LaTeX OCR
            case 'f':
                fillTool.update();
            case 'c':
                view.chooseColor();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        this.lastPressed = e.getKeyCode();

        switch (this.lastPressed) {
            case KeyEvent.VK_UP:
                view.currentTool.incrementSize(1);
            case KeyEvent.VK_DOWN:
                view.currentTool.incrementSize(-1);
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
