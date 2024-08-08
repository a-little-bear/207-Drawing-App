package use_case.press_button;

import lombok.Getter;
import use_case.ImageExportInputBoundary;
import use_case.InputBoundary;

import javax.swing.*;

public abstract class ButtonPressed extends AbstractAction {
    @Getter final InputBoundary interactor;
    @Getter final ImageExportInputBoundary imageExportInteractor;

    protected ButtonPressed(InputBoundary interactor) {
        this.interactor = interactor;
        this.imageExportInteractor = null;
    }

    protected ButtonPressed(InputBoundary interactor, ImageExportInputBoundary imageExportInteractor) {
        this.interactor = interactor;
        this.imageExportInteractor = imageExportInteractor;
    }
}
