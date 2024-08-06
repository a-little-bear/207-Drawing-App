package use_case.update_tool;

import entity.tools.Tool;
import interface_adapter.Controller;
import use_case.InputBoundary;
import use_case.InputData;

public interface UpdateTool <T extends Tool>{
    void update(T tool, InputData inputData, InputBoundary interactor);
}
