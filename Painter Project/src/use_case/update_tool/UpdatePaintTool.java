package use_case.update_tool;

import entity.tool.PaintTool;
import use_case.InputBoundary;
import use_case.InputData;

import java.awt.*;

public class UpdatePaintTool implements UpdateTool<PaintTool>{
    public void update(PaintTool paintTool, InputData inputData, InputBoundary interactor) {
        int x = inputData.getXCoord();
        int y = inputData.getYCoord();
        Color color = interactor.getCurrentColor(); // getting color from the interactor

        if (color == null) {
            System.err.println("Error: Color is null in UpdatePaintTool.update");
            color = Color.BLACK; // Defaulting to black if null
        }

        if (inputData.getMouseIsActive()) {
            interactor.getCanvasManager().paintLine(
                    inputData.getLastXCoord(), inputData.getLastYCoord(), x, y,
                    color, paintTool.getSize());
        }

        inputData.setLastXCoord(x);
        inputData.setLastYCoord(y);
    }
}
