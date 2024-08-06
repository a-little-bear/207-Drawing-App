package app;

import interface_adapter.Controller;
import view.View;

public class DrawingAppThread implements Runnable{

    private final Thread thread = new Thread(this);
    private final View view;
    private final Controller controller;

    /**
     * Instantiates a new DrawingAppThread with the specified view and controller.
     *
     * @param view the view to update and render
     * @param controller the controller to update the view
     */
    public DrawingAppThread(View view, Controller controller){
        this.view = view;
        this.controller = controller;

        startThread();
    }

    /**
     * Starts the main thread for updating and rendering the view.
     */
    public void startThread() {
        thread.start();
    }

    /**
     * The main loop that updates and repaints the view.
     */
    @Override
    public void run() {
        while (thread != null) {
            controller.update();
            view.repaint();
            try {
                Thread.sleep(16); // Approximately 60 FPS
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
