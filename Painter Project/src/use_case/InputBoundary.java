package use_case;

import entity.tools.Tool;
import interface_adapter.ViewModel;

import java.awt.*;

public interface InputBoundary{
    Color getCurrentColor();

    <T extends Tool> void switchTool(T tool);

    OutputBoundary getPresenter();

    void update();

    ViewModel getViewModel();

    InputData getInputData();
}
