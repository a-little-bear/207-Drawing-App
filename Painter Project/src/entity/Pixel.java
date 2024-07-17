package entity;

import main.GamePanel;

import java.awt.*;

public class Pixel extends Entity {

    GamePanel gp;
    Color color;
    Boolean rendered;

    public Pixel(GamePanel gp, int x, int y, Color color) {
        this.gp = gp;
        this.x = x;
        this.y = y;
        this.color = color;
        rendered = false;
    }

    public void update() {
        //TODO Implement update
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void render(boolean rendered) {
        this.rendered = rendered;
    }


    public void draw(Graphics2D g2) {
        if (rendered) {
            g2.setColor(color);
            g2.fillRect(x, y, gp.tileSize, gp.tileSize);
        }
    }
}