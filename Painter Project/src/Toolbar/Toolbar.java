package Toolbar;

import javax.swing.*;

import java.util.ArrayList;

public class Toolbar extends JPanel {
    private ArrayList<AbstractToolButton> toolbuttons;

    public Toolbar(ArrayList<AbstractToolButton> toolbuttons) {
        this.toolbuttons = toolbuttons;
        this.updateToolbar();
    }

    public void updateToolbar() {
        
    }
}
