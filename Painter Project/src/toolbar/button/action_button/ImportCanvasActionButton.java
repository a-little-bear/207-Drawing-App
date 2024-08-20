package toolbar.button.action_button;

import javax.swing.*;
import java.awt.event.KeyEvent;

public class ImportCanvasActionButton extends AbstractActionButton {
    private Icon icon;
    private final static String iconPath = "Painter Project/images/ImportCanvasActionButton.png";
    private final static String toolTip = "Import Canvas (I)";

    public ImportCanvasActionButton(Action listener) {
        super(iconPath, toolTip, listener);
        getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_I, 0), "i");
        getActionMap().put("i", listener);
    }
}
