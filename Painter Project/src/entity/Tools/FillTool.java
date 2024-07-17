package entity.Tools;

import main.Controllers.Controller;
import main.GamePanel;

import java.awt.*;
import java.awt.image.BufferedImage;

public class FillTool implements Tool {
    private GamePanel gp;
    private Controller controller;
    private int size;
    private Color color;
    private int lastX, lastY;
    private boolean isDrawing;

    public FillTool(GamePanel gp, Controller controller) {
        this.gp = gp;
        this.controller = controller;
        this.color = Color.BLACK;
        this.size = 5;
        this.isDrawing = false;
    }

    @Override
    public void update() {
        BufferedImage image = gp.canvasManager.getTopLayer().getCanvasImage();
        int x = controller.mouse.xCoord;
        int y = controller.mouse.yCoord;
        // TO DO: implement dfs fill with colour using bounds of gamepanel and FillTool's colour
    }

    @Override
    public void draw(Graphics2D g2) {
        int x = controller.mouse.xCoord;
        int y = controller.mouse.yCoord;
        g2.setColor(color);
        g2.fillRect(x, y, size, size); // Updated to use size directly
    }

    @Override
    public void setSize(int size){ }

    @Override
    public void incrementSize(int increment){ }
}
