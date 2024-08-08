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

    public Controller(InputBoundary interactor, InputData inputData, Mouse mouse){
        this.interactor = interactor;
        this.mouse = mouse;
        this.inputData = inputData;
    }

    public void update() {
        inputData.updateMouse(mouse);
        interactor.update();
    }
}
