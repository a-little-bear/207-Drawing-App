package interface_adapter.press_button.tool_toggle_button;

import use_case.InputBoundary;
import interface_adapter.press_button.ButtonPressed;
import interface_adapter.press_button.ButtonPressedFacade;

import java.awt.event.ActionEvent;

public class FillButtonPressed extends ButtonPressed {


    public FillButtonPressed(InputBoundary interactor) {
        super(interactor);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ButtonPressedFacade.pressFillButton(super.getInteractor().getInputData());
    }
}
