package use_case.press_button.action_button;

import use_case.InputBoundary;
import use_case.press_button.ButtonPressed;

import java.awt.event.ActionEvent;

/**
 * The LatexOCRButtonPressed class extends the {@link ButtonPressed} class to handle
 * the action of triggering LaTeX OCR (Optical Character Recognition) functionality.
 * When the LaTeX OCR button is pressed, this class invokes the LaTeX OCR process
 * through the interactor.
 */
public class LatexOCRButtonPressed extends ButtonPressed {

    /**
     * Constructs a LatexOCRButtonPressed instance with the specified interactor.
     * The interactor is used to trigger the LaTeX OCR process.
     *
     * @param interactor The {@link InputBoundary} used to interact with the application's logic.
     */
    public LatexOCRButtonPressed(InputBoundary interactor) {
        super(interactor);
    }

    /**
     * Invoked when the LaTeX OCR button is pressed. This method triggers the LaTeX OCR
     * process by calling the interactor's {@code latexOCR} method.
     *
     * @param e The {@link ActionEvent} triggered by the button press.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        super.getInteractor().latexOCR();
    }
}
