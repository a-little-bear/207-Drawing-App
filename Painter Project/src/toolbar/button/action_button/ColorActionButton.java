package toolbar.button.action_button;

import javax.swing.*;
import java.awt.event.KeyEvent;

public class ColorActionButton extends AbstractActionButton {
    private Icon icon;
    private final static String iconPath = "Painter Project/images/ColourActionButton.png";
    private final static String toolTip = "Colour Picker (C)";

    public ColorActionButton(Action listener) {
        super(iconPath, toolTip, listener);
        getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_C, 0), "c");
        getActionMap().put("c", listener);
    }
}
