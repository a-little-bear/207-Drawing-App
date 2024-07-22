package entity.tools;

import java.awt.*;

public interface Tool {
    void update();

    void draw(Graphics2D g2);

    void incrementSize(int incr);
    void setColor(Color newColor);
}
