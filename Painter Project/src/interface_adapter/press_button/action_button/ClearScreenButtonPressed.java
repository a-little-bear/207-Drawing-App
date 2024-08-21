package interface_adapter.press_button.action_button;

import use_case.InputBoundary;
import interface_adapter.press_button.ButtonPressed;

import java.awt.event.ActionEvent;

/**
 * The ClearScreenButtonPressed class extends the {@link ButtonPressed} class to handle
 * the action of pressing the clear screen button. When the button is pressed,
 * this class triggers the clear screen process within the canvas manager.
 */
public class ClearScreenButtonPressed extends ButtonPressed {

    /**
     * Constructs a ClearScreenButtonPressed instance with the specified interactor.
     * The interactor is used to interact with the canvas manager to initiate
     * the color selection process.
     *
     * @param interactor The {@link InputBoundary} used to interact with the canvas manager.
     */
    public ClearScreenButtonPressed(InputBoundary interactor) { super(interactor); }

    /**
     * Invoked when the clear screen button is pressed. This method triggers the clear
     * screen process by calling the canvas manager's clearScreen method.
     *
     * @param e The {@link ActionEvent} triggered by the button press.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        super.getInteractor().getCanvasManager().clearScreen();
    }
}
