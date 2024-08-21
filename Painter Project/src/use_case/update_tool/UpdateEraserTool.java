package use_case.update_tool;

import entity.tool.EraserTool;
import use_case.InputBoundary;
import use_case.InputData;

/**
 * The UpdateEraserTool class implements the {@link UpdateTool} interface and provides functionality
 * for updating the state and behavior of an {@link EraserTool}. This includes drawing a line
 * on the canvas based on the eraser tool's settings whenever the mouse is active.
 */
public class UpdateEraserTool implements UpdateTool<EraserTool> {

    /**
     * Updates the eraser tool's behavior by drawing a line from the last recorded position
     * to the current position on the canvas. This method is called when the mouse is active,
     * allowing the eraser to continuously erase along the path of the mouse movement.
     *
     * @param tool       The {@link EraserTool} being used for the update.
     * @param inputData  The input data containing the current and previous coordinates,
     *                   as well as the state of the mouse.
     * @param interactor The interactor that provides access to the canvas manager and other
     *                   application logic.
     */
    @Override
    public void update(EraserTool tool, InputData inputData, InputBoundary interactor) {
        int x = inputData.getXCoord();
        int y = inputData.getYCoord();

        if (inputData.getMouseIsActive()) {
            // Draw the line from the last point to the current point
            interactor.getCanvasManager().paintLine(
                    inputData.getLastXCoord(), inputData.getLastYCoord(), x, y,
                    tool.getColor(), tool.getSize());
        }
        inputData.setLastXCoord(x);
        inputData.setLastYCoord(y);
    }
}
