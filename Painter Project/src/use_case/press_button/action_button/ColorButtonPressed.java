package use_case.press_button.action_button;

import use_case.InputBoundary;
import use_case.press_button.ButtonPressed;

import java.awt.event.ActionEvent;

/**
 * The ColorButtonPressed class extends the {@link ButtonPressed} class to handle
 * the action of pressing the color picker button. When the button is pressed,
 * this class triggers the color selection process within the canvas manager.
 */
public class ColorButtonPressed extends ButtonPressed {

    /**
     * Constructs a ColorButtonPressed instance with the specified interactor.
     * The interactor is used to interact with the canvas manager to initiate
     * the color selection process.
     *
     * @param interactor The {@link InputBoundary} used to interact with the canvas manager.
     */
    public ColorButtonPressed(InputBoundary interactor) {
        super(interactor);
    }

    /**
     * Invoked when the color picker button is pressed. This method triggers the color
     * selection process by calling the canvas manager's chooseColor method with the
     * current input data.
     *
     * @param e The {@link ActionEvent} triggered by the button press.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        super.getInteractor().getCanvasManager().chooseColor(super.getInteractor().getInputData());
    }
}
