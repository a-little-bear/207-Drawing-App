package toolbar;

import toolbar.button.Pressable;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.util.ArrayList;

/**
 * The Toolbar class represents a toolbar in the application, containing a collection of pressable buttons.
 * It is displayed as a JPanel with a horizontal layout and a defined size and border.
 */
public class Toolbar extends JPanel {
    public ArrayList<Pressable> buttons;
    private ButtonGroup toolButtons;

    /**
     * Constructs a Toolbar with the specified buttons and button group.
     * The toolbar is initialized with a default size, layout, and border.
     *
     * @param buttons    The list of {@link Pressable} buttons to be added to the toolbar.
     * @param toolButtons The {@link ButtonGroup} that groups the tool buttons for mutual exclusivity.
     */
    public Toolbar(ArrayList<Pressable> buttons, ButtonGroup toolButtons) {
        this.buttons = buttons;
        this.toolButtons = toolButtons;

        this.setPreferredSize(new Dimension(1280, 50));
        this.setLayout(new FlowLayout(FlowLayout.LEFT));

        Border border = new LineBorder(Color.BLACK, 1);
        this.setBorder(border);
    }
}
