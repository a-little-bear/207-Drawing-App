package use_case.update_tool;

import entity.tools.Tool;
import use_case.InputBoundary;
import use_case.InputData;

public class UpdateToolFacade<T extends Tool> {
    public UpdateToolFacade(T tool, InputData inputData, InputBoundary interactor) throws IllegalArgumentException{
        if (T.isinstanceof(PaintTool)){
            new UpdatePaintTool.update(tool, inputData, interactor);
        } else if (T.isinstanceof(EraserTool)){
            new UpdateEraserTool.update(tool, inputData, interactor);
        } else if (T.isinstanceof(FillTool)){
            new UpdateFillTool.update(tool, inputData, interactor);
        } else {
            throw new IllegalArgumentException("Tool not recognized");
        }
    }
}
