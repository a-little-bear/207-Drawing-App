package Toolbar;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

abstract class AbstractActionButton extends JButton implements ActionListener {
    private Icon icon;
    private String tooltip;

    public AbstractActionButton(Icon icon, String tooltip) {

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

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getActionCommand());
    }
}
