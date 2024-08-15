package interface_adapter.press_button.tool_toggle_button;

import interface_adapter.press_button.ButtonPressed;
import use_case.InputBoundary;
import interface_adapter.press_button.ButtonPressedFacade;

import java.awt.event.ActionEvent;

public class PaintButtonPressed extends ButtonPressed {

    public PaintButtonPressed(InputBoundary interactor) {
        super(interactor);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ButtonPressedFacade.pressPaintButton(super.getInteractor().getInputData());
    }
}
