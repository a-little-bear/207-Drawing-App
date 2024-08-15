package interface_adapter.press_button.action_button;

import use_case.ImageExportInputBoundary;
import use_case.InputBoundary;
import interface_adapter.press_button.ButtonPressed;

import java.awt.event.ActionEvent;

public class SaveButtonPressed extends ButtonPressed {
    public SaveButtonPressed(InputBoundary interactor, ImageExportInputBoundary imageExportInteractor) {
        super(interactor, imageExportInteractor);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        super.getImageExportInteractor().saveImage(super.getInteractor().getCanvasManager());
    }

}
