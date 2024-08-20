package toolbar.button.tool_toggle_button;

import javax.swing.*;
import java.awt.event.KeyEvent;

/**
 * The PaintToolToggleButton class extends the {@link AbstractToolToggleButton} to create a toggle button
 * specifically for selecting the paint brush tool in a toolbar. It provides a default icon, tooltip,
 * and maps the "Q" key to trigger the button's action.
 */
public class PaintToolToggleButton extends AbstractToolToggleButton {
    private final static String iconPath = "Painter Project/images/PaintToolButton.png";
    private final static String toolTip = "Brush Tool (Q)";

    /**
     * Constructs a PaintToolToggleButton with the specified action listener.
     * The button is initialized with a default icon, tooltip, and a key binding
     * that triggers the action when the "Q" key is pressed.
     *
     * @param listener The {@link Action} to be executed when the button is toggled or when the "Q" key is pressed.
     */
    public PaintToolToggleButton(Action listener) {
        super(iconPath, toolTip, listener);
        getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_Q, 0), "q");
        getActionMap().put("q", listener);
    }

    /**
     * Processes key bindings for the PaintToolToggleButton. If the "Q" key is pressed,
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

        if (b && ks.getKeyCode() == KeyEvent.VK_Q) {
            requestFocusInWindow();
            setSelected(true);
        }

        return b;
    }
}
