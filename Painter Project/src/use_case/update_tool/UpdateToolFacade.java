package use_case.update_tool;

import entity.tool.EraserTool;
import entity.tool.FillTool;
import entity.tool.PaintTool;
import entity.tool.Tool;
import use_case.InputBoundary;
import use_case.InputData;

/**
 * The UpdateToolFacade class provides a unified interface for updating different types of tools.
 * It determines the specific tool type at runtime and delegates the update process to the appropriate
 * tool update class (e.g., {@link UpdatePaintTool}, {@link UpdateEraserTool}, {@link UpdateFillTool}).
 */
public class UpdateToolFacade {

    /**
     * Updates the given tool based on its type. This method delegates the update process to the appropriate
     * tool-specific update class, ensuring that the correct behavior is applied based on the tool type.
     *
     * @param tool       The tool to be updated. This can be a {@link PaintTool}, {@link EraserTool}, or {@link FillTool}.
     * @param inputData  The input data containing the current and previous coordinates, as well as the state of the mouse.
     * @param interactor The interactor that provides access to the canvas manager and other application logic.
     * @param <T>        The type of tool being updated, which must extend the {@link Tool} interface.
     */
    public static <T extends Tool> void update(T tool, InputData inputData, InputBoundary interactor) {
        if (tool.getClass().equals(PaintTool.class)) {
            UpdatePaintTool updatePaintTool = new UpdatePaintTool();
            updatePaintTool.update((PaintTool) tool, inputData, interactor);
        } else if (tool.getClass().equals(EraserTool.class)) {
            UpdateEraserTool updateEraserTool = new UpdateEraserTool();
            updateEraserTool.update((EraserTool) tool, inputData, interactor);
        } else if (tool.getClass().equals(FillTool.class) && inputData.getMouseIsActive()) {
            UpdateFillTool updateFillTool = new UpdateFillTool();
            updateFillTool.update((FillTool) tool, inputData, interactor);
        }
    }
}
