package app;

import interface_adapter.Controller;
import use_case.OutputBoundary;
import view.View;

public class DrawingAppThread implements Runnable{

    private final Thread thread = new Thread(this);
    private final View view;
    private final Controller controller;
    private final OutputBoundary presenter;

    public DrawingAppThread(View view, Controller controller, OutputBoundary presenter){
        this.view = view;
        this.controller = controller;
        this.presenter = presenter;

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
            view.update();
            presenter.update();
            try {
                Thread.sleep(16); // Approximately 60 FPS
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
