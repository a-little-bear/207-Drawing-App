package toolbar.button.action_button;

import javax.swing.*;

public class ClearScreenActionButton extends AbstractActionButton {

    private Icon icon;
    private final static String iconPath = "Painter Project/images/ClearScreenActionButton.png";
    private final static String toolTip = "Clear Screen";

    public ClearScreenActionButton(Action listener) {
        super(iconPath,
                toolTip,
                listener);
    }
}
