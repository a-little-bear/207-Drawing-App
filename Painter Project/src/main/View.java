package main;

import entity.canvas.CanvasManager;
import entity.tools.PaintTool;
import entity.tools.Tool;
import controllers.Controller;

import javax.swing.*;
import java.awt.*;

/**
 * The View class extends JPanel and implements the Runnable interface.
 * It handles the drawing and updating of the canvas, as well as managing input events.
 */
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

    /**
     * Instantiates a new View with the specified properties and initializes the canvas manager and input controllers.
     */
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

    /**
     * Starts the main thread for updating and rendering the view.
     */
    public void startThread() {
        thread = new Thread(this);
        thread.start();
    }

    /**
     * The main loop that updates and repaints the view.
     */
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

    /**
     * Updates the current tool.
     */
    public void update() {
        currentTool.update();
    }

    /**
     * Paints the components of the view, including the canvas and the current tool.
     *
     * @param g the Graphics object to draw on
     */
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        canvasManager.draw(g2);
        currentTool.draw(g2);
        g2.dispose();
    }

    /**
     * Returns the controller managing the input devices.
     *
     * @return the controller
     */
    public Controller getController() {
        return controller;
    }

    /**
     * Opens a color picker dialog to choose a color for painting.
     */
    public void chooseColor() {
        canvasManager.chooseColor(this);
    }

    /**
     * Returns the currently active color.
     *
     * @return the active color
     */
    public Color getColor() {
        return activeColor;
    }

    /**
     * Sets the active color for painting and updates the current tool's color.
     *
     * @param color the new color to set
     */
    public void setColor(Color color) {
        activeColor = color;
        currentTool.setColor(color);
    }
    // Added this getter method for testing purposes
    public CanvasManager getCanvasManager() {
        return canvasManager;
    }
}
