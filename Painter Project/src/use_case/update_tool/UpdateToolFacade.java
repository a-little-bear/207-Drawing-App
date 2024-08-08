package use_case.update_tool;

import entity.tool.EraserTool;
import entity.tool.FillTool;
import entity.tool.PaintTool;
import entity.tool.Tool;
import use_case.InputBoundary;
import use_case.InputData;

public class UpdateToolFacade{

    public static <T extends Tool> void update(T tool, InputData inputData, InputBoundary interactor){
        if (tool.getClass().equals(PaintTool.class)){
            UpdatePaintTool updatePaintTool = new UpdatePaintTool();
            updatePaintTool.update((PaintTool) tool, inputData, interactor);
        } else if (tool.getClass().equals(EraserTool.class)){
            UpdateEraserTool updateEraserTool = new UpdateEraserTool();
            updateEraserTool.update((EraserTool) tool, inputData, interactor);
        } else if (tool.getClass().equals(FillTool.class) && inputData.getMouseIsActive()){
            UpdateFillTool updateFillTool = new UpdateFillTool();
            updateFillTool.update((FillTool) tool, inputData, interactor);
        }
    }
}
