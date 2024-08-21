package use_case.update_tool;

import entity.tool.Tool;
import use_case.InputBoundary;
import use_case.InputData;

/**
 * The UpdateTool interface defines a method for updating the state and behavior of a tool
 * used in the application. Implementing classes are responsible for handling the specific
 * logic needed to update the tool based on user input and interaction with the canvas.
 *
 * @param <T> The type of tool that this interface will update. It must extend the {@link Tool} interface.
 */
public interface UpdateTool<T extends Tool> {

    /**
     * Updates the tool's behavior based on the current input data and interactor.
     * This method is responsible for applying the tool's effect to the canvas
     * or managing its state in response to user input.
     *
     * @param tool       The tool being used for the update.
     * @param inputData  The input data containing the current and previous coordinates,
     *                   as well as the state of the mouse and other inputs.
     * @param interactor The interactor that provides access to the canvas manager and other
     *                   application logic.
     */
    void update(T tool, InputData inputData, InputBoundary interactor);
}
