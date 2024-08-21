package toolbar.button.tool_toggle_button;

import javax.swing.*;
import java.awt.event.KeyEvent;

/**
 * The FillToolToggleButton class extends the {@link AbstractToolToggleButton} to create a toggle button
 * specifically for selecting the fill tool in a toolbar. It provides a default icon, tooltip,
 * and maps the "F" key to trigger the button's action.
 */
public class FillToolToggleButton extends AbstractToolToggleButton {
    private final static String iconPath = "Painter Project/images/FillToolButton.png";
    private final static String toolTip = "Fill Tool (F)";

    /**
     * Constructs a FillToolToggleButton with the specified action listener.
     * The button is initialized with a default icon, tooltip, and a key binding
     * that triggers the action when the "F" key is pressed.
     *
     * @param listener The {@link Action} to be executed when the button is toggled or when the "F" key is pressed.
     */
    public FillToolToggleButton(Action listener) {
        super(iconPath, toolTip, listener);
        getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_F, 0), "f");
        getActionMap().put("f", listener);
    }

    /**
     * Processes key bindings for the FillToolToggleButton. If the "F" key is pressed,
     * the button gains focus and is selected.
     *
     * @param ks        The {@link KeyStroke} associated with the key event.
     * @param e         The {@link KeyEvent} triggered by the key press.
     * @param condition The condition under which the key event was triggered.
     * @param pressed   Indicates whether the key is pressed or released.
     * @return {@code true} if the key binding was processed, otherwise {@code false}.
     */
    @Override
    public boolean processKeyBinding(KeyStroke ks, KeyEvent e, int condition, boolean pressed) {
        boolean b = super.processKeyBinding(ks, e, condition, pressed);

        if (b && ks.getKeyCode() == KeyEvent.VK_F) {
            requestFocusInWindow();
            setSelected(true);
        }

        return b;
    }
}
