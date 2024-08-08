package entity.toolbar;

import use_case.InputBoundary;

import javax.swing.*;

public class ColourActionButton extends AbstractActionButton {
    private Icon icon;
    private final static String iconPath = "";
    private final static String toolTip = "Colour Picker (C)";
    private final InputBoundary interactor;

    public ColourActionButton(InputBoundary interactor) {
        super(iconPath, toolTip);
        this.interactor = interactor;
    }

    @Override
    public void performAction() {
        interactor.getCanvasManager().chooseColor(
                interactor.getPresenter().getViewModel());
    }
}
