package main;

import entity.canvas.CanvasManager;
import entity.tools.PaintTool;
import entity.tools.Tool;
import controllers.Controller;

import javax.swing.*;
import java.awt.*;

public class View extends JPanel implements Runnable {
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

    public View() {
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
    }

    public Color getColor() {
        return activeColor;
    }
    public void setColor(Color color) {
        activeColor = color;
        currentTool.setColor(color);
    }
}
