package canvas;

import main.GamePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CanvasManager {
    private final ArrayList<Canvas> layers = new ArrayList<>();
    private final int width;
    private final int height;

    public CanvasManager(int width, int height) {
        this.width = width;
        this.height = height;
        addLayer();
    }

    public void addLayer() {
        Canvas newLayer = new Canvas(width, height);
        layers.add(newLayer);
    }

    public Canvas getTopLayer() {
        return layers.get(layers.size() - 1);
    }

    public void paint(int x, int y, Color color, int size) {
        Canvas currentLayer = layers.get(layers.size() - 1); // Paint on the topmost layer
        currentLayer.paintArea(x, y, color, size);
    }

    public void paintLine(int x1, int y1, int x2, int y2, Color color, int size) {
        Canvas currentLayer = layers.get(layers.size() - 1); // Paint on the topmost layer
        currentLayer.paintLine(x1, y1, x2, y2, color, size);
    }

    public void draw(Graphics2D g2) {
        for (Canvas layer : layers) {
            layer.draw(g2);
        }
    }

    public Canvas collapseLayers() {
        //Method to collapse all the layers into 1 canvas

        return layers.get(0);   //Temporary Solution for Testing
    }

    public void LatexOCR() {
        collapseLayers().LatexOCR();
    }

    public void exportToPNG() {
        collapseLayers().exportToPNG();
    }

    public void chooseColor(GamePanel gp) {
        JFrame frame = new JFrame("Color Picker");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLayout(new GridLayout(2, 2, 10, 10));

        Color[] colors = {Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW, Color.MAGENTA, Color.CYAN, Color.GRAY};

        for (Color color : colors) {
            JButton colorButton = new JButton();
            colorButton.setBackground(color);
            colorButton.setPreferredSize(new Dimension(100, 100));
            colorButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    gp.setColor(color);
                    frame.dispose(); // Close the frame after selection
                }
            });
            frame.add(colorButton);
        }

        frame.pack();
        frame.setLocationRelativeTo(null); // Center the frame on the screen
        frame.setVisible(true);
    }
}
