package main.Controllers;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

// Implementation of this can be changed imo, this was just what i could think of on the spot 
public class Mouse implements MouseMotionListener, MouseListener {
    public boolean isActive;
    public int xCoord;
    public int yCoord;

    @Override
    public void mouseDragged(java.awt.event.MouseEvent e) {
        update(e);
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        update(e);
    }

    @Override
    public void mousePressed(java.awt.event.MouseEvent e) {
        if (e.getButton() == java.awt.event.MouseEvent.BUTTON1){
            isActive = true;
        }
        update(e);
    }

    @Override
    public void mouseReleased(java.awt.event.MouseEvent e) {
        if (e.getButton() == java.awt.event.MouseEvent.BUTTON1){
            isActive = false;
        }
        update(e);
    }

    @Override
    public void mouseClicked(java.awt.event.MouseEvent e) {
    }

    @Override
    public void mouseEntered(java.awt.event.MouseEvent e) {
    }

    @Override
    public void mouseExited(java.awt.event.MouseEvent e) {

    }

    public void update(java.awt.event.MouseEvent e) {
        xCoord = e.getX();
        yCoord = e.getY();
    }
}
