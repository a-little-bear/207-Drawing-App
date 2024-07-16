package main.Controllers;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keyboard implements KeyListener{
    public Boolean qP, wP, eP, rP, down, up;

    public Keyboard(){
        qP = false;
        wP = false;
        eP = false;
        rP = false;
        down = false;
        up = false;
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        
        // TODO Implement Key Press Events
        if (code == KeyEvent.VK_Q){
            qP = true;
        }
        else if (code == KeyEvent.VK_W){
            wP = true;
        }
        else if (code == KeyEvent.VK_E){
            eP = true;
        }
        else if (code == KeyEvent.VK_R){
            rP = true;
        }
        else if (code == KeyEvent.VK_DOWN){
            down = true;
        }
        else if (code == KeyEvent.VK_UP){
            up = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        
        // TODO Implement Key Press Events
        if (code == KeyEvent.VK_Q){
            qP = false;
        }
        else if (code == KeyEvent.VK_W){
            wP = false;
        }
        else if (code == KeyEvent.VK_E){
            eP = false;
        }
        else if (code == KeyEvent.VK_R){
            rP = false;
        }
        else if (code == KeyEvent.VK_DOWN){
            down = false;
        }
        else if (code == KeyEvent.VK_UP){
            up = false;
        }
    }
    
}
