package entity;

import main.Controllers.Controller;
import main.GamePanel;

import java.awt.*;

public class CursorM {
    private final GamePanel gp;
    private final Controller controller;

    public CursorM(GamePanel gp, Controller controller) {
        this.gp = gp;
        this.controller = controller;
    }

    public void update() {
        gp.currentTool.update();
    }

    public void draw(Graphics2D g2) {
        gp.currentTool.draw(g2);
    }
}
