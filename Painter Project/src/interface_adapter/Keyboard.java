package interface_adapter;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import entity.tools.EraserTool;
import entity.tools.FillTool;
import entity.tools.PaintTool;
import use_case.ImageExportInputBoundary;
import use_case.InputBoundary;
import use_case.ImageExportInteractor;
import use_case.create_tool.CreatePaintTool;

/**
 * The Keyboard class handles keyboard events and interacts with various tools and actions in the view.
 */
public class Keyboard implements KeyListener {
    private int lastPressed;
    private char lastTyped;
    private final ImageExportInputBoundary imageExportInteractor;
    private final InputBoundary interactor;

    /**
     * Instantiates a new Keyboard.
     *
     * @param view the view to be associated with this keyboard
     */
    public Keyboard(InputBoundary interactor) {
        this.interactor = interactor;
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
                imageExportInteractor.exportImage(interactor.getPresenter().getViewModel().getCanvasManager());
                break;
            case 'q':
                interactor.<PaintTool> switchTool(new CreatePaintTool.create(interactor.getCurrentColor()));
                break;
            case 'w':
                interactor.<EraserTool> switchTool(new CreateEraserTool.create(Color.WHITE));
                break;
            case 't':
                interactor.getPresenter().getViewModel().getCanvasManager().LatexOCR();
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
