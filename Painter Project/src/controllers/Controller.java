package controllers;

import main.View;

public class Controller {
    public Mouse mouse;

    public Keyboard keyboard;

    public Controller(View gp) {
        mouse = new Mouse(gp, this);
        keyboard = new Keyboard(gp, this);
    }
}
