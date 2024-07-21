package entity.Tools;

import main.Controllers.Controller;
import main.GamePanel;

import java.awt.*;

public class EraserTool implements Tool {
    private final GamePanel gp;
    private final Controller controller;
    private int size;
    private final Color color;
    private int lastX, lastY;
    private boolean isDrawing;

    public EraserTool(GamePanel gp, Controller controller) {
        this.gp = gp;
        this.controller = controller;
        this.color = Color.WHITE; //TODO GET TRANSPARANT TO WORK INSTEAD OF WHITE
        this.size = 20;
        this.isDrawing = false;
        // System.out.println("EraserTool Created");
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

    public void setSize(int size) {
        this.size = Math.max(size, 1);
    }

    public void incrementSize(int increment) {
        if (size < 1) {
            size = 1;
        } else {
            size += increment;
        }
    }
}
