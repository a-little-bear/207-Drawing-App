package use_case.press_button;

import lombok.Getter;
import use_case.ImageExportInputBoundary;
import use_case.InputBoundary;

import javax.swing.*;

/**
 * The ButtonPressed class is an abstract base class that handles the actions triggered by button presses.
 * It extends {@link AbstractAction} and provides common functionality for managing the interactor
 * and image export interactor, which are used to interact with the application's logic.
 */
public abstract class ButtonPressed extends AbstractAction {

    @Getter final InputBoundary interactor;
    @Getter final ImageExportInputBoundary imageExportInteractor;

    /**
     * Constructs a ButtonPressed instance with the specified interactor.
     * This constructor is used when the button press action does not require image export functionality.
     *
     * @param interactor The {@link InputBoundary} used to interact with the application's logic.
     */
    protected ButtonPressed(InputBoundary interactor) {
        this.interactor = interactor;
        this.imageExportInteractor = null;  // No image export interactor provided
    }

    /**
     * Constructs a ButtonPressed instance with the specified interactor and image export interactor.
     * This constructor is used when the button press action requires image export functionality.
     *
     * @param interactor           The {@link InputBoundary} used to interact with the application's logic.
     * @param imageExportInteractor The {@link ImageExportInputBoundary} used to handle image export functionality.
     */
    protected ButtonPressed(InputBoundary interactor, ImageExportInputBoundary imageExportInteractor) {
        this.interactor = interactor;
        this.imageExportInteractor = imageExportInteractor;
    }
}
