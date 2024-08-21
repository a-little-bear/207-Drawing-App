package interface_adapter.press_button.tool_toggle_button;

import interface_adapter.press_button.ButtonPressed;
import use_case.InputBoundary;
import interface_adapter.press_button.ButtonPressedFacade;

import java.awt.event.ActionEvent;

/**
 * The PaintButtonPressed class extends the {@link ButtonPressed} class to handle
 * the action of selecting the paint tool. When the paint button is pressed,
 * this class triggers the appropriate action to set the paint tool as the current tool.
 */
public class PaintButtonPressed extends ButtonPressed {

    /**
     * Constructs a PaintButtonPressed instance with the specified interactor.
     * The interactor is used to interact with the application's logic, particularly
     * for setting the current tool to the paint tool.
     *
     * @param interactor The {@link InputBoundary} used to interact with the application's logic.
     */
    public PaintButtonPressed(InputBoundary interactor) {
        super(interactor);
    }

    /**
     * Invoked when the paint tool button is pressed. This method triggers the action
     * to set the paint tool as the current tool by calling the appropriate method
     * in the {@link ButtonPressedFacade}.
     *
     * @param e The {@link ActionEvent} triggered by the button press.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        ButtonPressedFacade.pressPaintButton(super.getInteractor().getInputData());
    }
}
