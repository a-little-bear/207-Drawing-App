package main.Controllers;

import entity.Tools.EraserTool;
import entity.Tools.FillTool;
import entity.Tools.PaintTool;
import main.GamePanel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keyboard implements KeyListener{
    private final GamePanel gp;
    private final Controller controller;
    public Keyboard(GamePanel gp, Controller controller){
        this.gp = gp;
        this.controller = controller;
    }
    @Override
    public void keyTyped(KeyEvent e) {
        char code = Character.toLowerCase(e.getKeyChar());
        if (code == 'q') {
            gp.currentTool = new PaintTool(gp, controller);
        }
        if (code == 'w') {
            gp.currentTool = new EraserTool(gp, controller);
        }
        if (code == 'e') {
            gp.canvasManager.exportToPNG();
        }
        if (code == 't') {
            gp.canvasManager.LatexOCR();
        }
        if (code == 'f') {
            FillTool tool = new FillTool(gp, controller);
            tool.update();
        }
        if (code == 'c') {
            gp.chooseColor();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_DOWN){
            gp.currentTool.incrementSize(-1);
        }
        else if (code == KeyEvent.VK_UP){
            gp.currentTool.incrementSize(1);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
    
}
