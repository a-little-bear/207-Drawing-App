package toolbar.button.action_button;

import use_case.ImageExportInputBoundary;
import use_case.InputBoundary;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class SaveActionButton extends AbstractActionButton {
    private Icon icon;
    private final static String iconPath = "Painter Project/images/SaveActionButton.png";
    private final static String toolTip = "Save (S)";

    public SaveActionButton(Action listener) {
        super(iconPath, toolTip, listener);
        getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_S, 0), "s");
        getActionMap().put("s", listener);
    }

}
