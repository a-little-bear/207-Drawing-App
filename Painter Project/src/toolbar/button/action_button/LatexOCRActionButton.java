package toolbar.button.action_button;

import javax.swing.*;
import java.awt.event.KeyEvent;

/**
 * The LatexOCRActionButton class extends the {@link AbstractActionButton} to create a button
 * specifically for triggering LaTeX OCR functionality in a toolbar. It provides a default icon,
 * tooltip, and maps the "T" key to trigger the button's action.
 */
public class LatexOCRActionButton extends AbstractActionButton {
    private final static String iconPath = "Painter Project/images/LatexOCRActionButton.png";
    private final static String toolTip = "Latex OCR (T)";

    /**
     * Constructs a LatexOCRActionButton with the specified action listener.
     * The button is initialized with a default icon, tooltip, and a key binding
     * that triggers the action when the "T" key is pressed.
     *
     * @param listener The {@link Action} to be executed when the button is pressed or when the "T" key is pressed.
     */
    public LatexOCRActionButton(Action listener) {
        super(iconPath, toolTip, listener);
        getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_T, 0), "t");
        getActionMap().put("t", listener);
    }
}
