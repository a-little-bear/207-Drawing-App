package entity;

import entity.Tools.EraserTool;
import entity.Tools.PaintTool;
import main.GamePanel;
import main.Controllers.Controller;

public class KeyBoardM {
    private GamePanel gp;
    private Controller controller;

    public KeyBoardM(GamePanel gp, Controller controller) {
        this.gp = gp;
        this.controller = controller;
    }

    public void update() {
        if(controller.keyboard.qP == true){
            gp.currentTool = new PaintTool(gp, controller);
        }
        else if (controller.keyboard.wP == true){
            gp.currentTool = new EraserTool(gp, controller);
        }
        else if (controller.keyboard.eP == true){
            gp.canvasManager.exportToPNG();
        }
        else if (controller.keyboard.up){
            gp.currentTool.incrementSize(1);
        }
        else if (controller.keyboard.down){
            gp.currentTool.incrementSize(-1);
        }
    }
}
