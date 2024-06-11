package canvas;

import entity.Pixel;
import main.GamePanel;

import java.awt.*;
import java.util.ArrayList;

public class Canvas {
    GamePanel gp;
    Pixel[][] canvas;

    public Canvas (GamePanel gp){
        this.gp = gp;
        newCanvas(gp);
    }

    public void newCanvas(GamePanel gp){
        canvas = new Pixel[gp.maxScreenRow][gp.maxScreenCol];
        int col = 0;
        int row = 0;
        int x = 0;
        int y = 0;
        while (col < gp.maxScreenCol && row < gp.maxScreenRow){
            Pixel p = new Pixel(gp, x, y, Color.WHITE);
            canvas [y][x] = p;
            col ++;
            x += gp.tileSize;
            if (col == gp.maxScreenCol){
                col = 0;
                x = 0;
                row++;
                y += gp.tileSize;
            }
        }
    }

    public Pixel[] locatePixel(int x, int y, int size){
        ArrayList<Pixel> pixels = new ArrayList<Pixel>();
        for (int i = x; i < x+size; i++) {
            for (int j = y; j < y + size; j++) {
                pixels.add(canvas[j][i]);
            }
        }
        return pixels.toArray(new Pixel[0]);
    }

    public void paintArea(Pixel[] area, Color color){
        for (Pixel pixel : area) {
            pixel.setColor(color);
            pixel.render(true);
        }
    }

    public void draw(Graphics2D g2){
        for (int i = 0; i< canvas.length; i++){
            for (int j = 0; j < canvas[i].length; j++){
                canvas[i][j].draw(g2);
            }
        }
    }
}
