package entity;

import java.awt.Graphics2D;

import main.GamePanel;
import main.Controllers.Controller;

public class CursorM{
    private GamePanel gp;
    private Controller controller;

    public CursorM(GamePanel gp, Controller controller) {
        this.gp = gp;
        this.controller = controller;
    }

    public void update() {
        gp.currentTool.update();
    }

    public void draw(Graphics2D g2){
        gp.currentTool.draw(g2);
    }
}
