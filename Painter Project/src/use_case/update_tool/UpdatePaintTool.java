package use_case.update_tool;

import entity.tool.PaintTool;
import use_case.InputBoundary;
import use_case.InputData;

import java.awt.*;

/**
 * The UpdatePaintTool class implements the {@link UpdateTool} interface and provides functionality
 * for updating the state and behavior of a {@link PaintTool}. This includes drawing a line
 * on the canvas based on the paint tool's settings whenever the mouse is active.
 */
public class UpdatePaintTool implements UpdateTool<PaintTool> {

    /**
     * Updates the paint tool's behavior by drawing a line from the last recorded position
     * to the current position on the canvas. This method is called when the mouse is active,
     * allowing the paint tool to continuously draw along the path of the mouse movement.
     *
     * @param paintTool  The {@link PaintTool} being used for the update.
     * @param inputData  The input data containing the current and previous coordinates,
     *                   as well as the state of the mouse.
     * @param interactor The interactor that provides access to the canvas manager and other
     *                   application logic.
     */
    @Override
    public void update(PaintTool paintTool, InputData inputData, InputBoundary interactor) {
        int x = inputData.getXCoord();
        int y = inputData.getYCoord();
        Color color = interactor.getCurrentColor(); // Get the current color from the interactor

        if (color == null) {
            System.err.println("Error: Color is null in UpdatePaintTool.update");
            color = Color.BLACK; // Default to black if color is null
        }

        if (inputData.getMouseIsActive()) {
            // Draw the line from the last point to the current point
            interactor.getCanvasManager().paintLine(
                    inputData.getLastXCoord(), inputData.getLastYCoord(), x, y,
                    color, paintTool.getSize());
        }

        // Update the last coordinates in the input data
        inputData.setLastXCoord(x);
        inputData.setLastYCoord(y);
    }
}
