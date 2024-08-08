package toolbar.button.tool_toggle_button;

import entity.tool.FillTool;
import use_case.InputBoundary;
import use_case.create_tool.CreateFillTool;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.HashSet;
import java.util.Set;

public class FillToolToggleButton extends AbstractToolToggleButton {
    private Icon icon;
    private final static String iconPath = "Painter Project/images/FillToolButton.png";
    private final static String toolTip = "Fill Tool (F)";

    public FillToolToggleButton(Action listener) {
        super(iconPath, toolTip, listener);
        getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_F, 0), "f");
        getActionMap().put("f", listener);
    }

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
