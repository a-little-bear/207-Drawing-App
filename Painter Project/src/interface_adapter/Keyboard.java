package interface_adapter;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import entity.tools.*;
import use_case.ImageExportInputBoundary;
import use_case.InputBoundary;
import use_case.ImageExportInteractor;
import use_case.create_tool.CreateEraserTool;
import use_case.create_tool.CreateFillTool;
import use_case.create_tool.CreatePaintTool;
import use_case.update_tool.UpdateFillTool;

/**
 * The Keyboard class handles keyboard events and interacts with various tools and actions in the view.
 */
public class Keyboard implements KeyListener {
    private int lastPressed, lastReleased;
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
                imageExportInteractor.saveImage(interactor.getPresenter().getViewModel().getCanvasManager());
                break;
            case 'q':
                CreatePaintTool tP = new CreatePaintTool();
                interactor.<PaintTool> switchTool(tP.create(interactor.getCurrentColor()));
                break;
            case 'w':
                CreateEraserTool tE = new CreateEraserTool();
                interactor.<EraserTool> switchTool(tE.create(Color.WHITE));
                break;
            case 't':
                interactor.getPresenter().getViewModel().getCanvasManager().LatexOCR();
                break;
            case 'f':
                CreateFillTool tF = new CreateFillTool();
                UpdateFillTool fillTool = new UpdateFillTool();
                fillTool.update(tF.create(interactor.getCurrentColor()),
                        interactor.getInputData(), interactor);
                break;
            case 'c':
                interactor.getPresenter().getViewModel().getCanvasManager().chooseColor(
                        interactor.getPresenter().getViewModel());
                break;
            case 'e':
                imageExportInteractor.exportCanvasManager(interactor.getPresenter().getViewModel().getCanvasManager());
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
                interactor.getViewModel().getCurrentTool().incrementSize(1);
                break;
            case KeyEvent.VK_DOWN:
                interactor.getViewModel().getCurrentTool().incrementSize(-1);
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
