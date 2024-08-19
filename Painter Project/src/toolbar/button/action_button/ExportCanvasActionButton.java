package toolbar.button.action_button;

import javax.swing.*;
import java.awt.event.KeyEvent;

public class ExportCanvasActionButton extends AbstractActionButton {
    private Icon icon;
    private final static String iconPath = "";
    private final static String toolTip = "Export Canvas (E)";

    public ExportCanvasActionButton(Action listener) {
        super(iconPath, toolTip, listener);
        getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_C, 0), "e");
        getActionMap().put("e", listener);
    }
}
