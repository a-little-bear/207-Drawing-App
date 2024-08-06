package view;

import entity.canvas.CanvasManager;
import entity.tools.PaintTool;
import entity.tools.Tool;
import interface_adapter.Controller;
import interface_adapter.ViewModel;

import javax.swing.*;
import java.awt.*;

/**
 * The View class extends JPanel and implements the Runnable interface.
 * It handles the drawing and updating of the canvas, as well as managing input events.
 */
public class View extends JPanel  {

    private final ViewModel viewModel;

    /**
     * Instantiates a new View with the specified properties and initializes the canvas manager and input controllers.
     */
    public View(ViewModel viewModel) {
        this.viewModel = viewModel;

        this.setPreferredSize(this.viewModel.getDimension());
        this.setBackground(this.viewModel.getBackgroundColor());
        this.setDoubleBuffered(true);

        this.setFocusable(true); // Fixed for keyboard events
    }

    /**
     * Gets the view model associated with this view.
     *
     * @return the view model
     */
    @Override
    public Dimension getPreferredSize() {
        return viewModel.getDimension(); // Ensure the preferred size matches the canvas dimensions
    }

    /**
     * Paints the components of the view, including the canvas and the current tool.
     *
     * @param g the Graphics object to draw on
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        viewModel.paint(g2);
        g2.dispose();
    }
}
