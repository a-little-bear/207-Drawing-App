package controllers;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import entity.tools.EraserTool;
import entity.tools.FillTool;
import entity.tools.PaintTool;
import main.View;
import use_cases.ImageExportInteractor;

/**
 * The Keyboard class handles keyboard events and interacts with various tools and actions in the view.
 */
public class Keyboard implements KeyListener {
    private int lastPressed, lastReleased;
    private char lastTyped;
    private final ImageExportInteractor imageExportInteractor;
    private final View view;

    /**
     * Instantiates a new Keyboard.
     *
     * @param view the view to be associated with this keyboard
     */
    public Keyboard(View view) {
        this.view = view;
        this.imageExportInteractor = new ImageExportInteractor();
    }

    /**
     * Invoked when a key has been typed.
     *
     * @param e the event to be processed
     */
    @Override
    public void keyTyped(KeyEvent e) {
        this.lastTyped = Character.toLowerCase(e.getKeyChar());
        switch (this.lastTyped) {
            case 's':
                imageExportInteractor.exportImage(view);
                break;
            case 'q':
                view.currentTool = new PaintTool(view, view.getController());
                break;
            case 'w':
                view.currentTool = new EraserTool(view, view.getController());
                break;
            case 't':
                view.canvasManager.LatexOCR();
                break;
            case 'f':
                new FillTool(view, view.getController()).update();
                break;
            case 'c':
                view.chooseColor();
                break;
        }
    }

    /**
     * Invoked when a key has been pressed.
     *
     * @param e the event to be processed
     */
    @Override
    public void keyPressed(KeyEvent e) {
        this.lastPressed = e.getKeyCode();

        switch (this.lastPressed) {
            case KeyEvent.VK_UP:
                view.currentTool.incrementSize(1);
                break;
            case KeyEvent.VK_DOWN:
                view.currentTool.incrementSize(-1);
                break;
        }
    }

    /**
     * Invoked when a key has been released.
     *
     * @param e the event to be processed
     */
    @Override
    public void keyReleased(KeyEvent e) {
        this.lastReleased = e.getKeyCode();
    }
}
