package interface_adapter.press_button.action_button;

import use_case.ImageExportInputBoundary;
import use_case.InputBoundary;
import interface_adapter.press_button.ButtonPressed;

import java.awt.event.ActionEvent;

/**
 * The SaveButtonPressed class extends the {@link ButtonPressed} class to handle
 * the action of saving the current canvas as an image. When the save button is pressed,
 * this class triggers the image export process through the image export interactor.
 */
public class SaveButtonPressed extends ButtonPressed {

    /**
     * Constructs a SaveButtonPressed instance with the specified interactor and image export interactor.
     * The interactor is used to retrieve the canvas manager, and the image export interactor
     * is used to save the current canvas as an image.
     *
     * @param interactor           The {@link InputBoundary} used to interact with the application's logic.
     * @param imageExportInteractor The {@link ImageExportInputBoundary} used to handle image export functionality.
     */
    public SaveButtonPressed(InputBoundary interactor, ImageExportInputBoundary imageExportInteractor) {
        super(interactor, imageExportInteractor);
    }

    /**
     * Invoked when the save button is pressed. This method triggers the image export process
     * by calling the {@code saveImage} method on the image export interactor, passing the
     * current canvas manager.
     *
     * @param e The {@link ActionEvent} triggered by the button press.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        super.getImageExportInteractor().saveImage(super.getInteractor().getCanvasManager());
    }
}
