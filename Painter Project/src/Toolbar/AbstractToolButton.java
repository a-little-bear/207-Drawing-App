package Toolbar;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

abstract class AbstractToolButton extends JToggleButton implements ActionListener {
    private Icon icon;
    private String tooltip;

    /**
     * Constructor to initialize the tool toggle button with an icon and a tooltip.
     *
     * @param iconPath The path to the icon image file.
     * @param tooltip  The tooltip text for the button.
     */
    public AbstractToolButton(String iconPath, String tooltip) {
        setIcon(iconPath);
        setTooltip(tooltip);
        setupButton();
    }

    /**
     * Sets up the toggle button with the icon and tooltip.
     */
    private void setupButton() {
        setIcon(icon);
        setToolTipText(tooltip);
        addActionListener(this);
    }

    /**
     * Abstract method to equip the current tool.
     */
    public abstract void equipTool();

    /**
     * Gets the icon used for this tool button.
     *
     * @return the Icon currently set for the button.
     */
    public Icon getIcon() {
        return icon;
    }

    /**
     * Sets the icon for this tool button using the specified file path.
     *
     * @param iconPath the path to the image file to be used as the icon.
     *                 The icon will be updated with the image at the specified path.
     */
    public void setIcon(String iconPath) {
        this.icon = new ImageIcon(iconPath);
        setIcon(this.icon);
    }

    /**
     * Gets the tooltip text associated with this tool button.
     *
     * @return a String containing the tooltip text for the button.
     */
    public String getTooltip() {
        return tooltip;
    }

    /**
     * Sets the tooltip text for this tool button.
     *
     * @param tooltip the {@link String} to be displayed as the tooltip for the button.
     *                The tooltip provides additional information about the tool's function.
     */
    public void setTooltip(String tooltip) {
        this.tooltip = tooltip;
        setToolTipText(tooltip);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (this.isSelected()) {
            this.setText("ON");
        } else {
            this.setText("OFF");
        }
    }
}
