package main;

import canvas.CanvasManager;
import entity.KeyBoardM;
import entity.Tools.PaintTool;
import entity.Tools.Tool;
import main.Controllers.Controller;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;


public class GamePanel extends JPanel implements Runnable {
    private final int scale = 1;
    public final int tileSize = scale;
    public final int maxScreenCol = 1920 / scale;
    private final int screenWidth = tileSize * maxScreenCol;
    public final int maxScreenRow = 1080 / scale;
    private final int screenHeight = tileSize * maxScreenRow;

    public CanvasManager canvasManager;
    public Tool currentTool;
    private final Controller controller;
    private Thread thread;
    private Color activeColor = Color.BLACK;

    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.WHITE);
        this.setDoubleBuffered(true);

        controller = new Controller(this);
        canvasManager = new CanvasManager(screenWidth, screenHeight);

        currentTool = new PaintTool(this, controller);

        this.addMouseListener(controller.mouse);
        this.addMouseMotionListener(controller.mouse);
        this.addKeyListener(controller.keyboard);
        this.setFocusable(true); // Fixed for keyboard events
    }

    public int getScreenWidth() {
        return screenWidth;
    }

    public int getScreenHeight() {
        return screenHeight;
    }

    public ArrayList<Integer> getWidthHeight() {
        return new ArrayList<Integer>(Arrays.asList(screenWidth, screenHeight));
    }

    public void startThread() {
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        while (thread != null) {
            update();
            repaint();
            try {
                Thread.sleep(16); // Approximately 60 FPS
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void update() {
        currentTool.update();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        canvasManager.draw(g2);
        currentTool.draw(g2);
        g2.dispose();
    }

    public void chooseColor() {
        canvasManager.chooseColor(this);
        currentTool.setColor(activeColor);
    }

    public Color getColor() {
        return activeColor;
    }
    public void setColor(Color color) {
        activeColor = color;
    }
}
