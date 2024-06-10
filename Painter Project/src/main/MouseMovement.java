package main;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

// Implementation of this can be changed imo, this was just what i could think of on the spot 
public class MouseMovement extends Mouse implements MouseMotionListener {
    
    @Override
    public void mouseDragged(java.awt.event.MouseEvent e) {
        update(e);
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        update(e);
    }
}
