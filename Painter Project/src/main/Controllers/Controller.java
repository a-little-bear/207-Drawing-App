package main.Controllers;

import main.GamePanel;

public class Controller {
    public Mouse mouse;

    public Keyboard keyboard;

    public Controller(GamePanel gp) {
        mouse = new Mouse(gp, this);
        keyboard = new Keyboard(gp, this);
    }
}
