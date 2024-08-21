package toolbar.button.action_button;

import javax.swing.*;

/**
 * The ClearScreenActionButton class extends the {@link AbstractActionButton} to create a button
 * specifically for the clear screen tool in a toolbar. It provides a default icon and tooltip.
 */
public class ClearScreenActionButton extends AbstractActionButton {

    private final static String iconPath = "Painter Project/images/ClearScreenActionButton.png";
    private final static String toolTip = "Clear Screen";

    /**
     * Constructs a ClearScreenActionButton with the specified action listener.
     * The button is initialized with a default icon, tooltip.
     *
     * @param listener The {@link Action} to be executed when the button is pressed
     */
    public ClearScreenActionButton(Action listener) {
        super(iconPath,
                toolTip,
                listener);
    }
}
