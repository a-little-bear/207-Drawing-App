package interface_adapter.press_button.tool_toggle_button;

import use_case.InputBoundary;
import interface_adapter.press_button.ButtonPressed;
import interface_adapter.press_button.ButtonPressedFacade;

import java.awt.event.ActionEvent;

/**
 * The EraserButtonPressed class extends the {@link ButtonPressed} class to handle
 * the action of selecting the eraser tool. When the eraser button is pressed,
 * this class triggers the appropriate action to set the eraser tool as the current tool.
 */
public class EraserButtonPressed extends ButtonPressed {

    /**
     * Constructs an EraserButtonPressed instance with the specified interactor.
     * The interactor is used to interact with the application's logic, particularly
     * for setting the current tool to the eraser.
     *
     * @param interactor The {@link InputBoundary} used to interact with the application's logic.
     */
    public EraserButtonPressed(InputBoundary interactor) {
        super(interactor);
    }

    /**
     * Invoked when the eraser tool button is pressed. This method triggers the action
     * to set the eraser tool as the current tool by calling the appropriate method
     * in the {@link ButtonPressedFacade}.
     *
     * @param e The {@link ActionEvent} triggered by the button press.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        ButtonPressedFacade.pressEraserButton(super.getInteractor().getInputData());
    }
}
