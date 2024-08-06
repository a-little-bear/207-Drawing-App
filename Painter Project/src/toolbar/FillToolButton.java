package toolbar;

import entity.tools.FillTool;
import use_case.InputBoundary;
import use_case.create_tool.CreateFillTool;

import javax.swing.*;

public class FillToolButton extends AbstractToolButton {
    private Icon icon;
    private final static String iconPath = "";
    private final static String toolTip = "Fill Tool (F)";
    private final InputBoundary interactor;

    public FillToolButton(InputBoundary interactor) {
        super(iconPath, toolTip);
        this.interactor = interactor;
    }

    public void equipTool() {
        CreateFillTool fillTool = new CreateFillTool();
        interactor.<FillTool> switchTool(fillTool.create(interactor.getCurrentColor()));
    }
}
