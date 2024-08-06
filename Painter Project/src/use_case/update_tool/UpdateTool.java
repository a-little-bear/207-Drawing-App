package use_case.update_tool;

import entity.tools.Tool;
import use_case.InputBoundary;
import use_case.InputData;

public interface UpdateTool <T extends Tool>{
    /**
     * Updates the tool with the current input data.
     *
     * @param tool the tool to update
     * @param inputData the current input data
     * @param interactor the input boundary
     */
    void update(T tool, InputData inputData, InputBoundary interactor);
}
