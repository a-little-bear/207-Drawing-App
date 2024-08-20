package view;

import interface_adapter.ViewModel;

import javax.swing.*;
import java.awt.*;

/**
 * The View class extends {@link JPanel} and is responsible for handling the drawing and updating
 * of the canvas. It interacts with the {@link ViewModel} to retrieve the current state of the
 * application and render it appropriately on the screen.
 */
public class View extends JPanel {

    private final ViewModel viewModel;

    /**
     * Constructs a new View with the specified {@link ViewModel}.
     * The view is initialized with the dimensions, background color, and other properties
     * as defined by the {@link ViewModel}.
     *
     * @param viewModel The {@link ViewModel} that provides the state and properties for the view.
     */
    public View(ViewModel viewModel) {
        this.viewModel = viewModel;

        this.setPreferredSize(this.viewModel.getDimension());
        this.setBackground(this.viewModel.getBackgroundColor());
        this.setDoubleBuffered(true);
    }

    /**
     * Updates the view's properties such as dimensions and background color based on the current state
     * of the {@link ViewModel}, and triggers a repaint to refresh the canvas.
     */
    public void update() {
        this.setPreferredSize(this.viewModel.getDimension());
        this.setBackground(this.viewModel.getBackgroundColor());
        this.setDoubleBuffered(true);
        repaint();
    }

    /**
     * Paints the components of the view, including the canvas and the current tool.
     * This method is called whenever the view needs to be rendered, and it uses the current
     * state from the {@link ViewModel} to draw the canvas and other elements.
     *
     * @param g The {@link Graphics} object used for drawing on the component.
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        viewModel.paint(g2);
        g2.dispose();
    }
}
