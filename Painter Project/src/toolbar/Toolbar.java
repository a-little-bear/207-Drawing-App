package toolbar;

import toolbar.button.Pressable;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.util.ArrayList;

public class Toolbar extends JPanel {
    public ArrayList<Pressable> buttons;
    private ButtonGroup toolButtons;

    public Toolbar(ArrayList<Pressable> buttons, ButtonGroup toolButtons) {
        this.buttons = buttons;
        this.toolButtons = toolButtons;

        this.setPreferredSize(new Dimension(1280, 50));
        this.setLayout(new FlowLayout(FlowLayout.LEFT));

        Border border = new LineBorder(Color.BLACK, 1);
        this.setBorder(border);
    }
}
