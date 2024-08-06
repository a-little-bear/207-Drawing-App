package Toolbar;

import use_case.InputBoundary;

import javax.swing.*;

import java.util.ArrayList;

public class Toolbar extends JPanel {
    private ButtonGroup toolButtons;
    private final InputBoundary interactor;

    public Toolbar(InputBoundary interactor) {
        this.toolButtons = new ButtonGroup();
        this.interactor = interactor;

        addPaintToolButton();
        addEraserToolButton();
        addFillToolButton();
    }

    public void addPaintToolButton() {
        toolButtons.add(new PaintToolButton(interactor));
    }

    public void addEraserToolButton() {
        toolButtons.add(new EraserToolButton(interactor));
    }

    public void addFillToolButton() {
        toolButtons.add(new FillToolButton(interactor));
    }

    public void add
}
