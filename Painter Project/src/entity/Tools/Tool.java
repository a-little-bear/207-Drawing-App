package entity.Tools;

import java.awt.Graphics2D;

public interface Tool {
    public void update();
    public void draw(Graphics2D g2);
    public void setSize(int size);
    public void incrementSize(int incr);
}
