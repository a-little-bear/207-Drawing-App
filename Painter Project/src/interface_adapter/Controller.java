package interface_adapter;

import lombok.Getter;
import use_case.InputBoundary;
import use_case.InputData;

/**
 * The Controller class manages the input devices (mouse and keyboard) for a given view.
 */
public class Controller {
    private final InputBoundary interactor;
    private final InputData inputData;
    @Getter private final Mouse mouse;
    @Getter private final Keyboard keyboard;

    /**
     * Instantiates a new Controller with the specified interactor, input data, and mouse.
     *
     * @param interactor the interactor to use
     * @param inputData  the input data to use
     * @param mouse      the mouse to use
     */
    public Controller(InputBoundary interactor, InputData inputData, Mouse mouse){
        this.interactor = interactor;
        this.mouse = mouse;
        keyboard = new Keyboard(interactor);
        this.inputData = inputData;
    }

    /**
     * Updates the input devices.
     */
    public void update() {
        inputData.updateMouse(mouse);
        interactor.update();
    }
}
