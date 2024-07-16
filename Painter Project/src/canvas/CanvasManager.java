package canvas;

import java.awt.*;
import java.util.ArrayList;
import main.GamePanel;

public class CanvasManager {
    private ArrayList<Canvas> layers = new ArrayList<>();
    private int width, height;

    public CanvasManager(int width, int height) {
        this.width = width;
        this.height = height;
        addLayer();
    }

    public void addLayer() {
        Canvas newLayer = new Canvas(width, height);
        layers.add(newLayer);
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

    public void exportToPNG() {
        collapseLayers().exportToPNG();
    }
}
