package use_case;

import entity.tools.Tool;
import interface_adapter.ViewModel;

import java.awt.*;

public interface InputBoundary{

    /**
     * Returns the current color.
     *
     * @return the current color
     */
    Color getCurrentColor();

    /**
     * Switches the current tool to the given tool.
     *
     * @param tool the tool to switch to
     * @param <T> the type of tool
     */
    <T extends Tool> void switchTool(T tool);

    /**
     * Returns the presenter.
     *
     * @return the presenter
     */
    OutputBoundary getPresenter();

    /**
     * Updates the input boundary.
     */
    void update();

    /**
     * Returns the view model.
     *
     * @return the view model
     */
    ViewModel getViewModel();

    /**
     * Returns the input data.
     *
     * @return the input data
     */
    InputData getInputData();
}
