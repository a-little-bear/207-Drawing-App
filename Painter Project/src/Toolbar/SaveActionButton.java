package Toolbar;

import use_case.ImageExportInputBoundary;
import use_case.InputBoundary;

import javax.swing.*;

public class SaveActionButton extends AbstractToolButton {
    private Icon icon;
    private final static String iconPath = "";
    private final static String toolTip = "Save Tool (S)";
    private final InputBoundary interactor;
    private final ImageExportInputBoundary imageExportInteractor;

    public SaveActionButton(InputBoundary interactor, ImageExportInputBoundary imageExportInteractor) {
        super(iconPath, toolTip);
        this.interactor = interactor;
        this.imageExportInteractor = imageExportInteractor;
    }

    @Override
    public void equipTool() {
        imageExportInteractor.exportImage(interactor.getPresenter().getViewModel().getCanvasManager());
    }
}
