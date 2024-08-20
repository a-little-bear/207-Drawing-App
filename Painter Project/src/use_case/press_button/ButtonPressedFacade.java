package use_case.press_button;

import use_case.InputData;
import use_case.create_tool.CreateEraserTool;
import use_case.create_tool.CreateFillTool;
import use_case.create_tool.CreatePaintTool;

/**
 * The ButtonPressedFacade class provides a simple interface to handle the actions
 * of pressing different tool buttons (paint, eraser, and fill). This facade simplifies
 * the process of setting the current tool in the application's input data by creating
 * the appropriate tool and updating the input data accordingly.
 */
public class ButtonPressedFacade {

    /**
     * Handles the action of pressing the paint tool button.
     * Creates a new paint tool and sets it as the current tool in the input data.
     *
     * @param inputData The input data that stores the state of the current tool and color.
     */
    public static void pressPaintButton(InputData inputData) {
        CreatePaintTool tP = new CreatePaintTool();
        inputData.setCurrentTool(tP.create(inputData.getCurrentColor()));
    }

    /**
     * Handles the action of pressing the eraser tool button.
     * Creates a new eraser tool and sets it as the current tool in the input data.
     *
     * @param inputData The input data that stores the state of the current tool and color.
     */
    public static void pressEraserButton(InputData inputData) {
        CreateEraserTool tE = new CreateEraserTool();
        inputData.setCurrentTool(tE.create(inputData.getCurrentColor()));
    }

    /**
     * Handles the action of pressing the fill tool button.
     * Creates a new fill tool and sets it as the current tool in the input data.
     *
     * @param inputData The input data that stores the state of the current tool and color.
     */
    public static void pressFillButton(InputData inputData) {
        CreateFillTool tF = new CreateFillTool();
        inputData.setCurrentTool(tF.create(inputData.getCurrentColor()));
    }
}
