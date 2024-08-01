package entity.canvas;

import interface_adapter.ViewModel;
import view.View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * The CanvasManager class manages multiple canvas layers and provides functionality
 * for painting and collapsing layers, as well as performing OCR and selecting colors.
 */
public class CanvasManager {
    private final ArrayList<Canvas> layers = new ArrayList<>();
    private final int width;
    private final int height;

    /**
     * Instantiates a new CanvasManager with the specified width and height.
     *
     * @param width  the width of the canvas
     * @param height the height of the canvas
     */
    public CanvasManager(int width, int height) {
        this.width = width;
        this.height = height;
        addLayer();
    }

    /**
     * Adds a new layer to the canvas manager.
     */
    public void addLayer() {
        Canvas newLayer = new Canvas(width, height);
        layers.add(newLayer);
    }

    /**
     * Gets the topmost layer of the canvas.
     *
     * @return the topmost canvas layer
     */
    public Canvas getTopLayer() {
        return layers.get(layers.size() - 1);
    }

    /**
     * Paints a filled rectangle on the topmost layer of the canvas.
     *
     * @param x     the x coordinate of the rectangle
     * @param y     the y coordinate of the rectangle
     * @param color the color of the rectangle
     * @param size  the size of the rectangle
     */
    public void paint(int x, int y, Color color, int size) {
        Canvas currentLayer = layers.get(layers.size() - 1); // Paint on the topmost layer
        currentLayer.paintArea(x, y, color, size);
    }

    /**
     * Paints a line between two points on the topmost layer of the canvas.
     *
     * @param x1    the starting x coordinate of the line
     * @param y1    the starting y coordinate of the line
     * @param x2    the ending x coordinate of the line
     * @param y2    the ending y coordinate of the line
     * @param color the color of the line
     * @param size  the size of the line
     */
    public void paintLine(int x1, int y1, int x2, int y2, Color color, int size) {
        Canvas currentLayer = layers.get(layers.size() - 1); // Paint on the topmost layer
        currentLayer.paintLine(x1, y1, x2, y2, color, size);
    }

    /**
     * Draws all canvas layers onto the provided Graphics2D object.
     *
     * @param g2 the Graphics2D object to draw on
     */
    public void draw(Graphics2D g2) {
        for (Canvas layer : layers) {
            layer.draw(g2);
        }
    }

    /**
     * Collapses all canvas layers into a single canvas.
     *
     * @return the collapsed canvas
     */
    public Canvas collapseLayers() {
        // Method to collapse all the layers into 1 canvas
        return layers.get(0);   // Temporary Solution for Testing
    }

    /**
     * Performs OCR on the collapsed canvas and displays the result in a dialog box.
     */
    public void LatexOCR() {
        collapseLayers().LatexOCR();
    }

    /**
     * Returns the BufferedImage representation of the collapsed canvas.
     *
     * @return the canvas image
     */
    public BufferedImage getCanvasImage() {
        return collapseLayers().getCanvasImage();
    }

    /**
     * Opens a color picker dialog to choose a color for painting.
     *
     * @param gp the view to set the selected color
     */
    public void chooseColor(ViewModel gp) {
        JFrame frame = new JFrame("Color Picker");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLayout(new GridLayout(2, 2, 10, 10));

        Color[] colors = {Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW, Color.MAGENTA, Color.CYAN, Color.GRAY, Color.BLACK};

        for (Color color : colors) {
            JButton colorButton = new JButton();
            colorButton.setBackground(color);
            colorButton.setPreferredSize(new Dimension(100, 100));
            colorButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    gp.setActiveColor(color);
                    frame.dispose(); // Close the frame after selection
                }
            });
            frame.add(colorButton);
        }

        frame.pack();
        frame.setLocationRelativeTo(null); // Center the frame on the screen
        frame.setVisible(true);
    }
    // Getter for layers
    public ArrayList<Canvas> getLayers() {
        return layers;
    }
}
