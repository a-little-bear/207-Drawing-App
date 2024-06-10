package entity;
import java.awt.Color;
import java.awt.Graphics2D;

import main.*;

public class CursorM extends Entity{

    GamePanel gp;
    Controller controller;
    int size;
    Color color;

    //TODO Implement change size and color of cursor method

    public CursorM(GamePanel gp, Controller controller){
        this.gp = gp;
        this.controller = controller;
        color = Color.BLACK;
        size = 5;
    }

    public void update(){
        x = controller.mouse.xCoord;
        y = controller.mouse.yCoord;
        if (controller.mouse.isActive){
            gp.canvas.paint(x, y, color, size);
        }
    }

    public void draw(Graphics2D g2){
        g2.setColor(color);
        g2.fillRect(x, y, gp.tileSize*size, gp.tileSize*size); // TODO: change to pen size when Implemented
    }
}
