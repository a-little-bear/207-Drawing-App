package toolbar.button.action_button;

import javax.swing.*;
import java.awt.event.KeyEvent;

/**
 * The ImportCanvasActionButton class extends the {@link AbstractActionButton} to create a button
 * specifically for importing a canvas in a toolbar. It provides a default icon, tooltip,
 * and maps the "I" key to trigger the button's action.
 */
public class ImportCanvasActionButton extends AbstractActionButton {
    private final static String iconPath = "Painter Project/images/ImportCanvasActionButton.png";
    private final static String toolTip = "Import Canvas (I)";

    /**
     * Constructs an ImportCanvasActionButton with the specified action listener.
     * The button is initialized with a default icon, tooltip, and a key binding
     * that triggers the action when the "I" key is pressed.
     *
     * @param listener The {@link Action} to be executed when the button is pressed or when the "I" key is pressed.
     */
    public ImportCanvasActionButton(Action listener) {
        super(iconPath, toolTip, listener);
        getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_I, 0), "i");
        getActionMap().put("i", listener);
    }
}
