package use_case.update_tool;

import entity.tool.PaintTool;
import use_case.InputBoundary;
import use_case.InputData;

public class UpdatePaintTool implements UpdateTool<PaintTool>{
    public void update(PaintTool paintTool, InputData inputData, InputBoundary interactor) {
        int x = inputData.getXCoord();
        int y = inputData.getYCoord();

        if (inputData.getMouseIsActive()) {
            // Draw the line from the last point to the current point
            interactor.getCanvasManager().paintLine(
                    inputData.getLastXCoord(), inputData.getLastYCoord(), x, y,
                    interactor.getCurrentColor(), paintTool.getSize());
        }
        inputData.setLastXCoord(x);
        inputData.setLastYCoord(y);
    }
}
