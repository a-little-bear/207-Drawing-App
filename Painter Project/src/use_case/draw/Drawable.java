package use_case.draw;

import use_case.InputData;

import java.awt.*;

public interface Drawable{
    void draw(Graphics2D g2, InputData inputData, Color color);
}
