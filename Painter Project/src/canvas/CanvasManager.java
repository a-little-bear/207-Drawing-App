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
    ArrayList<Canvas> layers = new ArrayList<Canvas>();

    public CanvasManager(GamePanel gp){
        this.gp = gp;
        newCanvas(gp);
    }

    public void newCanvas(GamePanel gp){
        Canvas layer = new Canvas(gp);
        layers.add(layer);
    }

    public void paint (int x, int y, Color color, int size){
        Canvas currentLayer = layers.get(0); // TODO change 0 to selected layer
        currentLayer.paintArea(currentLayer.locatePixel(x,y,size), color);
    }

    public void draw(Graphics2D g2){
        for (int i = 0; i < layers.size(); i++){
           layers.get(i).draw(g2);
        }
    }

}