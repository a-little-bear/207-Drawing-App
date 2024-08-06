package interface_adapter;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 * The Mouse controller class that handles mouse events and updates the cursor position.
 */
public class Mouse implements MouseMotionListener, MouseListener {
    public boolean isActive;
    public int xCoord;
    public int yCoord;

    /**
     * Invoked when a mouse button is pressed and dragged.
     *
     * @param e the mouse event
     */
    @Override
    public void mouseDragged(java.awt.event.MouseEvent e) {
        update(e);
    }

    /**
     * Invoked when the mouse cursor is moved.
     *
     * @param e the mouse event
     */
    @Override
    public void mouseMoved(MouseEvent e) {
        update(e);
    }

    /**
     * Invoked when a mouse button has been pressed.
     *
     * @param e the mouse event
     */
    @Override
    public void mousePressed(java.awt.event.MouseEvent e) {
        if (e.getButton() == java.awt.event.MouseEvent.BUTTON1) {
            isActive = true;
        }
        update(e);
    }

    /**
     * Invoked when a mouse button has been released.
     *
     * @param e the mouse event
     */
    @Override
    public void mouseReleased(java.awt.event.MouseEvent e) {
        if (e.getButton() == java.awt.event.MouseEvent.BUTTON1) {
            isActive = false;
        }
        update(e);
    }

    /**
     * Invoked when the mouse button has been clicked.
     *
     * @param e the mouse event
     */
    @Override
    public void mouseClicked(java.awt.event.MouseEvent e) {
    }

    /**
     * Invoked when the mouse enters a component.
     *
     * @param e the mouse event
     */
    @Override
    public void mouseEntered(java.awt.event.MouseEvent e) {
    }

    /**
     * Invoked when the mouse exits a component.
     *
     * @param e the mouse event
     */
    @Override
    public void mouseExited(java.awt.event.MouseEvent e) {

    }

    /**
     * Updates the cursor position based on the mouse event.
     *
     * @param e the mouse event
     */
    public void update(java.awt.event.MouseEvent e) {
        xCoord = e.getX();
        yCoord = e.getY();
    }
}
