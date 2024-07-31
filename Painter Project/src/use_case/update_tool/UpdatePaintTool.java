package use_case.update_tool;

import entity.tools.PaintTool;
import use_case.InputBoundary;
import use_case.InputData;

public class UpdatePaintTool implements UpdateTool<PaintTool>{
    public void update(PaintTool paintTool, InputData inputData, InputBoundary interactor) {
        int x = inputData.getXCoord;
        int y = inputData.getYCoord;

        if (inputData.mouseIsActive) {
            // Draw the line from the last point to the current point
            interactor.getPresenter().getViewModel().getCanvasManager().paintLine(
                    paintTool.getLastXCoord, paintTool.getLastYCoord, x, y,
                    paintTool.getColor, paintTool.getSize);
            inputData.setLastxCoord(x);
            inputData.setLastyCoord(y);
        }
    }
}
