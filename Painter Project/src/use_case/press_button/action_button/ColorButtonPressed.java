package use_case.press_button.action_button;

import use_case.InputBoundary;
import use_case.press_button.ButtonPressed;

import java.awt.event.ActionEvent;

public class ColorButtonPressed extends ButtonPressed {

    public ColorButtonPressed(InputBoundary interactor) {
        super(interactor);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        super.getInteractor().getCanvasManager().chooseColor(super.getInteractor().getInputData());
    }
}
