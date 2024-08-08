package toolbar;

import entity.tools.EraserTool;
import use_case.InputBoundary;
import use_case.create_tool.CreateEraserTool;

import javax.swing.*;
import java.awt.*;

public class EraserToolButton extends AbstractToolButton {
    private Icon icon;
    private final static String iconPath = "Painter Project/images/EraserToolButton.png";
    private final static String toolTip = "Eraser Tool (W)";
    private final InputBoundary interactor;

    public EraserToolButton(InputBoundary interactor) {
        super(iconPath, toolTip);
        this.interactor = interactor;
    }

    public void equipTool() {
        CreateEraserTool tE = new CreateEraserTool();
        interactor.<EraserTool> switchTool(tE.create(Color.WHITE));
    }
}
