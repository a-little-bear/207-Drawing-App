package use_case.draw;

import interface_adapter.Controller;
import use_case.InputBoundary;
import use_case.InputData;
import use_case.Interactor;

import java.awt.*;

public class DrawEraser implements Drawable{
    private final int size = 20;

    public void draw(Graphics2D g2, InputData inputData, Color color) {
        int x = inputData.getXCoord();
        int y = inputData.getYCoord();
        g2.setColor(color);
        g2.fillRect(x, y, size, size); // Updated to use size directly
    }
}
