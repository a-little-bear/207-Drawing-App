package toolbar.button.action_button;

import javax.swing.*;
import java.awt.event.KeyEvent;

/**
 * The SaveActionButton class extends the {@link AbstractActionButton} to create a button
 * specifically for saving the canvas or project in a toolbar. It provides a default icon,
 * tooltip, and maps the "S" key to trigger the button's action.
 */
public class SaveActionButton extends AbstractActionButton {
    private final static String iconPath = "Painter Project/images/SaveActionButton.png";
    private final static String toolTip = "Save (S)";

    /**
     * Constructs a SaveActionButton with the specified action listener.
     * The button is initialized with a default icon, tooltip, and a key binding
     * that triggers the action when the "S" key is pressed.
     *
     * @param listener The {@link Action} to be executed when the button is pressed or when the "S" key is pressed.
     */
    public SaveActionButton(Action listener) {
        super(iconPath, toolTip, listener);
        getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_S, 0), "s");
        getActionMap().put("s", listener);
    }
}
