package main;

import javax.swing.JPanel;

import canvas.CanvasManager;

import java.awt.*;
import entity.*;

public class GamePanel extends JPanel implements Runnable{
    
    final int pixelSize = 1;
    int scale = 1; // change for zoom?
    //TODO implement math correctly for zoom
    public final int tileSize = pixelSize*scale; //displayed tile size
    public final int maxScreenCol = 1920/scale;
    public final int maxScreenRow = 1080/scale;
    final int screenWidth = tileSize * maxScreenCol;
    final int screenHeight = tileSize * maxScreenRow; //should change

    Controller controller = new Controller();
    CursorM cursor = new CursorM(this,controller);
    Thread thread;

    //FPS
    int FPS = 60;

    public CanvasManager canvas = new CanvasManager(this);

    public GamePanel(){
        this.setPreferredSize(new Dimension(screenWidth,screenHeight));
        this.setBackground(Color.WHITE);
        this.setDoubleBuffered(true);
        this.addMouseListener(controller.mouse);
        this.addMouseMotionListener(controller.mouse);
        this.setFocusable(false);
        //TODO: uncomment when keyboard is implemented 
        //this.addKeyListener(controller.keyboard);
    }

    public void startThread(){
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run(){
        // TODO change so that it only updates when an action is performed instead of 60fps
        /*
        double drawInterval = 1000000000/FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;

        while(thread != null){
            currentTime = System.nanoTime();

            delta += (currentTime - lastTime) / drawInterval;

            lastTime = currentTime;
            if (delta>=1 ){
                //System.out.println(controller.mouse.m.getX()+" , "+controller.mouse.m.getY());
                update();
                repaint();
            }
        }
        */

        while(thread != null){
            update();
            repaint();
        }
    }

    public void update(){
        cursor.update();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        canvas.draw(g2);
        cursor.draw(g2);
        g2.dispose();
    }
}
