package toolbar;

import use_case.ImageExportInputBoundary;
import use_case.InputBoundary;

import javax.swing.*;

public class SaveActionButton extends AbstractActionButton {
    private Icon icon;
    private final static String iconPath = "";
    private final static String toolTip = "Save (S)";
    private final InputBoundary interactor;
    private final ImageExportInputBoundary imageExportInteractor;

    public SaveActionButton(InputBoundary interactor, ImageExportInputBoundary imageExportInteractor) {
        super(iconPath, toolTip);
        this.interactor = interactor;
        this.imageExportInteractor = imageExportInteractor;
    }

    @Override
    public void performAction() {
        imageExportInteractor.saveImage(interactor.getPresenter().getViewModel().getCanvasManager());
    }
}
