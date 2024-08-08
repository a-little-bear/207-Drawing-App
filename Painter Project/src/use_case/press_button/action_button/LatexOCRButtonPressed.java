package use_case.press_button.action_button;

import use_case.InputBoundary;
import use_case.press_button.ButtonPressed;

import java.awt.event.ActionEvent;

public class LatexOCRButtonPressed extends ButtonPressed {
    public LatexOCRButtonPressed(InputBoundary interactor) {
        super(interactor);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        super.getInteractor().latexOCR();
    }

}
