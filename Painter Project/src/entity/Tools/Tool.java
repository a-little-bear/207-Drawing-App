package entity.Tools;

import java.awt.*;

public interface Tool {
    void update();

    void draw(Graphics2D g2);

    void setSize(int size);

    void incrementSize(int incr);
}
