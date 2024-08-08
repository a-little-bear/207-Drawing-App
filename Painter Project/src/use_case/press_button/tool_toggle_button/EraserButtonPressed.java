package use_case.press_button.tool_toggle_button;

import use_case.InputBoundary;
import use_case.press_button.ButtonPressed;
import use_case.press_button.ButtonPressedFacade;

import java.awt.event.ActionEvent;

public class EraserButtonPressed extends ButtonPressed {

    public EraserButtonPressed(InputBoundary interactor) {
        super(interactor);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ButtonPressedFacade.pressEraserButton(super.getInteractor().getInputData());
    }
}
