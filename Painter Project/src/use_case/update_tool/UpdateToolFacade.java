package use_case.update_tool;

import entity.tools.EraserTool;
import entity.tools.FillTool;
import entity.tools.PaintTool;
import entity.tools.Tool;
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
        } else if (tool.getClass().equals(FillTool.class)){
            UpdateFillTool updateFillTool = new UpdateFillTool();
            updateFillTool.update((FillTool) tool, inputData, interactor);
        }
    }
}
