package toolbar;

import use_case.InputBoundary;

import javax.swing.*;

public class LatexOCRActionButton extends AbstractActionButton {
    private Icon icon;
    private final static String iconPath = "Painter Project/images/LatexOCRActionButton.png";
    private final static String toolTip = "Latex OCR (T)";
    private final InputBoundary interactor;

    public LatexOCRActionButton(InputBoundary interactor) {
        super(iconPath, toolTip);
        this.interactor = interactor;
    }

    @Override
    public void performAction() {
        interactor.getPresenter().getViewModel().getCanvasManager().LatexOCR();
    }
}
