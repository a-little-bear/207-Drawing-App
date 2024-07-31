package use_case.draw;

import use_case.InputData;

import java.awt.*;

public class DrawPaint implements Drawable{
    @Override
    public void draw(Graphics2D g2, InputData inputData, Color color) {

        int x = inputData.getXCoord();
        int y = inputData.getYCoord();
        g2.setColor(color);
        g2.fillRect(x, y, size, size); // Updated to use size directly
    }
}
