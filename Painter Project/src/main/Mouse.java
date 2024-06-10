package main;
import java.awt.event.MouseListener;


public class Mouse implements MouseListener{

    public boolean isActive;
    public int xCoord;
    public int yCoord;

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
