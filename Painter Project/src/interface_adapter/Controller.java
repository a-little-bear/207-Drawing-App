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

    /**
     * Constructs a new Controller with the specified interactor, input data, and mouse.
     *
     * @param interactor The interactor responsible for handling the input data.
     * @param inputData  The data object that stores the current state of the inputs.
     * @param mouse      The mouse object that tracks the user's mouse actions.
     */
    public Controller(InputBoundary interactor, InputData inputData, Mouse mouse){
        this.interactor = interactor;
        this.mouse = mouse;
        this.inputData = inputData;
    }

    /**
     * Updates the state of the input devices and triggers the interactor to process the inputs.
     */
    public void update() {
        inputData.updateMouse(mouse);
        interactor.update();
    }
}
