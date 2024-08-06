package use_case;

import entity.tools.Tool;
import interface_adapter.ViewModel;
import lombok.Getter;
import use_case.update_tool.UpdateToolFacade;

import java.awt.*;

public class Interactor implements InputBoundary{
    @Getter private final OutputBoundary presenter;
    @Getter private final InputData inputData;

    /**
     * Constructs a new interactor with the given presenter and input data.
     *
     * @param presenter the presenter
     * @param inputData the input data
     */
    public Interactor(OutputBoundary presenter, InputData inputData) {
        this.presenter = presenter;
        this.inputData = inputData;
    }

    /**
     * Returns the current color.
     *
     * @return the current color
     */
    public Color getCurrentColor(){
        return (Color) presenter.getViewModel().getActiveColor();
    }

    /**
     * Returns the input data.
     *
     * @return the input data
     */
    public <T extends Tool> void switchTool(T tool){
        presenter.getViewModel().setCurrentTool(tool);
    }

    /**
     * Returns the view model.
     *
     * @return the view model
     */
    public void update(){
        UpdateToolFacade.update(presenter.getViewModel().getCurrentTool(),
                getInputData(), this);
    }

    /**
     * Returns the presenter.
     *
     * @return the presenter
     */
    public ViewModel getViewModel() {
        return presenter.getViewModel();
    }
}
