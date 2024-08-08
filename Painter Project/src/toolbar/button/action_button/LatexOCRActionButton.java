package toolbar.button.action_button;

import use_case.InputBoundary;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class LatexOCRActionButton extends AbstractActionButton {
    private Icon icon;
    private final static String iconPath = "Painter Project/images/LatexOCRActionButton.png";
    private final static String toolTip = "Latex OCR (T)";

    public LatexOCRActionButton(Action listener) {
        super(iconPath, toolTip, listener);
        getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_T, 0), "t");
        getActionMap().put("t", listener);
    }

}
