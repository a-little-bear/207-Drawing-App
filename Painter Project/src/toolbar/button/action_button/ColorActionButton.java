package toolbar.button.action_button;

import javax.swing.*;
import java.awt.event.KeyEvent;

/**
 * The ColorActionButton class extends the {@link AbstractActionButton} to create a button
 * specifically for the color picker tool in a toolbar. It provides a default icon and tooltip,
 * and also maps the "C" key to trigger the button's action.
 */
public class ColorActionButton extends AbstractActionButton {
    private final static String iconPath = "Painter Project/images/ColourActionButton.png";
    private final static String toolTip = "Colour Picker (C)";

    /**
     * Constructs a ColorActionButton with the specified action listener.
     * The button is initialized with a default icon, tooltip, and a key binding
     * that triggers the action when the "C" key is pressed.
     *
     * @param listener The {@link Action} to be executed when the button is pressed or when the "C" key is pressed.
     */
    public ColorActionButton(Action listener) {
        super(iconPath, toolTip, listener);
        getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_C, 0), "c");
        getActionMap().put("c", listener);
    }
}
