package interface_adapter.press_button;

import use_case.InputData;
import use_case.create_tool.CreateEraserTool;
import use_case.create_tool.CreateFillTool;
import use_case.create_tool.CreatePaintTool;

public class ButtonPressedFacade{
    public static void pressPaintButton(InputData inputData){
        CreatePaintTool tP = new CreatePaintTool();
        inputData.setCurrentTool(tP.create(inputData.getCurrentColor()));
    }

    public static void pressEraserButton(InputData inputData){
        CreateEraserTool tE = new CreateEraserTool();
        inputData.setCurrentTool(tE.create(inputData.getCurrentColor()));
    }

    public static void pressFillButton(InputData inputData){
        CreateFillTool tF = new CreateFillTool();
        inputData.setCurrentTool(tF.create(inputData.getCurrentColor()));
    }
}
