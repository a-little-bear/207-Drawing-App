package toolbar.button.action_button;

import toolbar.button.Pressable;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

abstract class AbstractActionButton extends JButton implements Pressable {
    private Icon icon;
    private String tooltip;

    /**
     * Constructor to initialize the action button with an icon and a tooltip.
     *
     * @param iconPath The path to the icon image file.
     * @param tooltip  The tooltip text for the button.
     */
    public AbstractActionButton(String iconPath, String tooltip, Action listener) {
        setIcon(iconPath);
        setTooltip(tooltip);
        setupButton(listener);

        Dimension buttonSize = new Dimension(40, 40);
        setPreferredSize(buttonSize);
        setMinimumSize(buttonSize);
        setMaximumSize(buttonSize);
        setSize(buttonSize);
    }

    /**
     * Sets up the button with the icon and tooltip.
     */
    private void setupButton(Action listener) {
        setIcon(icon);
        setToolTipText(tooltip);
        addActionListener(listener);
    }

    /**
     * Gets the icon used for this action button.
     *
     * @return the Icon currently set for the button.
     */
    public Icon getIcon() {
        return icon;
    }

    /**
     * Sets the icon for this action button using the specified file path.
     *
     * @param iconPath the path to the image file to be used as the icon.
     *                 The icon will be updated with the image at the specified path.
     */
    public void setIcon(String iconPath) {
        this.icon = new ImageIcon(iconPath);
        setIcon(this.icon);
    }

    /**
     * Gets the tooltip text associated with this action button.
     *
     * @return a String containing the tooltip text for the button.
     */
    public String getTooltip() {
        return tooltip;
    }

    /**
     * Sets the tooltip text for this action button.
     *
     * @param tooltip the {@link String} to be displayed as the tooltip for the button.
     *                The tooltip provides additional information about the button's function.
     */
    public void setTooltip(String tooltip) {
        this.tooltip = tooltip;
        setToolTipText(tooltip);
    }
}
