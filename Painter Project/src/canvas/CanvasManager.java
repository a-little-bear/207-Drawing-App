package canvas;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.List;
import java.util.ArrayList;
import java.util.ListIterator;

import entity.Pixel;
import main.*;

public class CanvasManager{
    GamePanel gp;
    ArrayList<Pixel> canvas = new ArrayList<Pixel>();

    public CanvasManager(GamePanel gp){
        this.gp = gp;
        newCanvas(gp);
    }

    public void newCanvas(GamePanel gp){
        int col = 0;
        int row = 0;
        int x = 0;
        int y = 0;
        while (col < gp.maxScreenCol && row < gp.maxScreenRow){
            Pixel p = new Pixel(gp, x, y, Color.WHITE);
            canvas.add(p);
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

    public ArrayList locate_pixel(int x, int y, int size){
        ArrayList<Pixel> area = new ArrayList<Pixel>();
        for (int i = 0; i < canvas.size(); i++){
            Pixel pixel = canvas.get(i);
            if (x <= pixel.x && pixel.x <= x + size && y <= pixel.y && pixel.y <= y + size ){
                area.add(pixel);
            }
        }
        return area;
    }

    public void paint (int x, int y, Color color, int size){
        ArrayList <Pixel> area = locate_pixel(x, y, size);
        for  (int i = 0; i< area.size(); i++){
            area.get(i).setColor(color);
        }
    }

    public void draw(Graphics2D g2){
        for (int i = 0; i < canvas.size(); i++){
            Pixel pixel = canvas.get(i);
            pixel.draw(g2);
        }
    }

}