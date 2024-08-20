package toolbar.button.action_button;

import javax.swing.*;
import java.awt.event.KeyEvent;

/**
 * The ExportCanvasActionButton class extends the {@link AbstractActionButton} to create a button
 * specifically for exporting the canvas in a toolbar. It provides a default icon, tooltip,
 * and maps the "E" key to trigger the button's action.
 */
public class ExportCanvasActionButton extends AbstractActionButton {
    private final static String iconPath = "Painter Project/images/ExportCanvasActionButton.png";
    private final static String toolTip = "Export Canvas (E)";

    /**
     * Constructs an ExportCanvasActionButton with the specified action listener.
     * The button is initialized with a default icon, tooltip, and a key binding
     * that triggers the action when the "E" key is pressed.
     *
     * @param listener The {@link Action} to be executed when the button is pressed or when the "E" key is pressed.
     */
    public ExportCanvasActionButton(Action listener) {
        super(iconPath, toolTip, listener);
        getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_E, 0), "e");
        getActionMap().put("e", listener);
    }
}
