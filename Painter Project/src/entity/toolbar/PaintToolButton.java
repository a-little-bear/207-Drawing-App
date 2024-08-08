package entity.toolbar;

import entity.tool.PaintTool;
import use_case.InputBoundary;
import use_case.create_tool.CreatePaintTool;

import javax.swing.*;

public class PaintToolButton extends AbstractToolButton {
    private Icon icon;
    private final static String iconPath = "Painter Project/images/PaintToolButton.png";
    private final static String toolTip = "Brush Tool (Q)";
    private final InputBoundary interactor;

    public PaintToolButton(InputBoundary interactor) {
        super(iconPath, toolTip);
        this.interactor = interactor;
    }

    public void equipTool() {
        CreatePaintTool tP = new CreatePaintTool();
        interactor.<PaintTool> switchTool(tP.create(interactor.getCurrentColor()));
    }
}
