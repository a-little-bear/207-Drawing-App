package entity.tools;

import controllers.Controller;
import main.View;

import java.awt.*;

public class PaintTool implements Tool {
    private final View gp;
    private final Controller controller;
    private int size;
    private Color color;
    private int lastX, lastY;
    private boolean isDrawing;

    public PaintTool(View gp, Controller controller) {
        this.gp = gp;
        this.controller = controller;
        this.color = gp.getColor();
        this.size = 5;
        this.isDrawing = false;
        // System.out.println("PaintTool Created");
    }

    @Override
    public void update() {
        int x = controller.mouse.xCoord;
        int y = controller.mouse.yCoord;

        if (controller.mouse.isActive) {
            if (!isDrawing) {
                // Starting a new line
                lastX = x;
                lastY = y;
                isDrawing = true;
            }
            // Draw the line from the last point to the current point
            gp.canvasManager.paintLine(lastX, lastY, x, y, color, size);
            lastX = x;
            lastY = y;
        } else {
            isDrawing = false;
        }
    }

    @Override
    public void draw(Graphics2D g2) {
        int x = controller.mouse.xCoord;
        int y = controller.mouse.yCoord;
        g2.setColor(color);
        g2.fillRect(x, y, size, size); // Updated to use size directly
    }

    @Override
    public void setColor(Color newColor) {
        color = newColor;
    }

    public void incrementSize(int increment) {
        if (size < 1) {
            size = 1;
        } else {
            size += increment;
        }
    }
}
