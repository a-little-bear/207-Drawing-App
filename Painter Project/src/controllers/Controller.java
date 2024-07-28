package controllers;

import main.View;

/**
 * The Controller class manages the input devices (mouse and keyboard) for a given view.
 */
public class Controller {
    /**
     * The mouse controller.
     */
    public Mouse mouse;

    /**
     * The keyboard controller.
     */
    public Keyboard keyboard;

    /**
     * Instantiates a new Controller with the specified view.
     *
     * @param view the view to be associated with this controller
     */
    public Controller(View view) {
        mouse = new Mouse(view);
        keyboard = new Keyboard(view);
    }
}
