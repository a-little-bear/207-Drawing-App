package toolbar.button.tool_toggle_button;

import entity.tool.PaintTool;
import use_case.InputBoundary;
import use_case.create_tool.CreatePaintTool;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.HashSet;
import java.util.Set;

public class PaintToolToggleButton extends AbstractToolToggleButton {
    private Icon icon;
    private final static String iconPath = "Painter Project/images/PaintToolButton.png";
    private final static String toolTip = "Brush Tool (Q)";

    public PaintToolToggleButton(Action listener) {
        super(iconPath, toolTip, listener);
        getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_Q, 0), "q");
        getActionMap().put("q", listener);
    }

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
