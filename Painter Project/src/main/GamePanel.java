package main;

import javax.swing.JPanel;
import java.awt.*;
import canvas.CanvasManager;
import entity.CursorM;
import entity.KeyBoardM;
import entity.Tools.PaintTool;
import entity.Tools.Tool;
import main.Controllers.Controller;


public class GamePanel extends JPanel implements Runnable {
    private final int scale = 1;
    public final int tileSize = scale;
    public final int maxScreenCol = 1920 / scale;
    public final int maxScreenRow = 1080 / scale;
    private final int screenWidth = tileSize * maxScreenCol;
    private final int screenHeight = tileSize * maxScreenRow;

    public CanvasManager canvasManager;
    private Controller controller;
    private CursorM cursor;
    private KeyBoardM keyboard;
    private Thread thread;

    public Tool currentTool;

    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.WHITE);
        this.setDoubleBuffered(true);

        controller = new Controller();
        cursor = new CursorM(this, controller);
        keyboard = new KeyBoardM(this, controller);
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
        cursor.update();
        keyboard.update();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        canvasManager.draw(g2);
        cursor.draw(g2);
        g2.dispose();
    }
}
