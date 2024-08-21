package app;

import interface_adapter.Controller;
import use_case.OutputBoundary;
import view.View;

/**
 * This class represents a thread responsible for managing the main loop of the drawing application.
 * It handles the periodic updating and rendering of the view.
 */
public class DrawingAppThread implements Runnable{

    private final Thread thread = new Thread(this);
    private final View view;
    private final Controller controller;
    private final OutputBoundary presenter;

    /**
     * Constructs a new DrawingAppThread with the specified view, controller, and presenter.
     * This constructor initializes the thread and starts it immediately.
     *
     * @param view       The view component responsible for rendering the application.
     * @param controller The controller component responsible for handling user input and updating the model.
     * @param presenter  The output boundary (presenter) responsible for displaying the output of the use case.
     */
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
     * The main loop that updates the controller, view, and presenter at regular intervals.
     * This loop runs continuously until the thread is interrupted.
     * It maintains a frame rate of 60 frames per second.
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
