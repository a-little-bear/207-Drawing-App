package use_case.press_button.tool_toggle_button;

import use_case.InputBoundary;
import use_case.press_button.ButtonPressed;
import use_case.press_button.ButtonPressedFacade;

import java.awt.event.ActionEvent;

/**
 * The FillButtonPressed class extends the {@link ButtonPressed} class to handle
 * the action of selecting the fill tool. When the fill button is pressed,
 * this class triggers the appropriate action to set the fill tool as the current tool.
 */
public class FillButtonPressed extends ButtonPressed {

    /**
     * Constructs a FillButtonPressed instance with the specified interactor.
     * The interactor is used to interact with the application's logic, particularly
     * for setting the current tool to the fill tool.
     *
     * @param interactor The {@link InputBoundary} used to interact with the application's logic.
     */
    public FillButtonPressed(InputBoundary interactor) {
        super(interactor);
    }

    /**
     * Invoked when the fill tool button is pressed. This method triggers the action
     * to set the fill tool as the current tool by calling the appropriate method
     * in the {@link ButtonPressedFacade}.
     *
     * @param e The {@link ActionEvent} triggered by the button press.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        ButtonPressedFacade.pressFillButton(super.getInteractor().getInputData());
    }
}
