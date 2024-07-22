package controllers;

import main.View;

public class Controller {
    public Mouse mouse;

    public Keyboard keyboard;

    public Controller(View view) {
        mouse = new Mouse(view);
        keyboard = new Keyboard(view);
    }
}
