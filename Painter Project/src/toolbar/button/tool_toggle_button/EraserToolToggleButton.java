package toolbar.button.tool_toggle_button;

import entity.tool.EraserTool;
import use_case.InputBoundary;
import use_case.create_tool.CreateEraserTool;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.HashSet;
import java.util.Set;

public class EraserToolToggleButton extends AbstractToolToggleButton {
    private Icon icon;
    private final static String iconPath = "Painter Project/images/EraserToolButton.png";
    private final static String toolTip = "Eraser Tool (W)";

    public EraserToolToggleButton(Action listener) {
        super(iconPath, toolTip, listener);
        getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_W, 0), "w");
        getActionMap().put("w", listener);
    }

    @Override
    public boolean processKeyBinding(KeyStroke ks, KeyEvent e, int condition, boolean pressed) {
        boolean b = super.processKeyBinding(ks, e, condition, pressed);

        if (b && ks.getKeyCode() == KeyEvent.VK_W) {
            requestFocusInWindow();
            setSelected(true);
        }

        return b;
    }
}
