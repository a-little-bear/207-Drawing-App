package entity;

import java.awt.Color;
import java.awt.Graphics2D;
import main.GamePanel;

public class Pixel extends Entity{

    GamePanel gp;
    Color color;

    public  Pixel(GamePanel gp, int x,int y, Color color){
        this.gp = gp;
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public void update(){
        //TODO Implement update
    }

    public void setColor(Color color){
        this.color = color;
    }

    public void draw(Graphics2D g2){
        g2.setColor(color);
        g2.fillRect(x, y, gp.tileSize, gp.tileSize);
    }
}