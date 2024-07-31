package use_case;

import entity.tools.PaintTool;
import entity.tools.Tool;
import interface_adapter.ViewModel;
import lombok.Getter;
import use_case.update_tool.UpdateToolFacade;

import java.awt.*;

public class Interactor implements InputBoundary{
    @Getter private final OutputBoundary presenter;
    @Getter private final InputData inputData;

    public Interactor(OutputBoundary presenter, InputData inputData) {
        this.presenter = presenter;
        this.inputData = inputData;
    }

    public Color getCurrentColor(){
        return (Color) presenter.getViewModel().getActiveColor();
    }

    public <T extends Tool> void switchTool(T tool){
        presenter.getViewModel().setCurrentTool(tool);
    }

    public void update(){
        UpdateToolFacade updateToolFacade = new UpdateToolFacade();
        updateToolFacade.update(presenter.getViewModel().getCurrentTool(),
                getInputData(), this);
    }

    @Override
    public ViewModel getViewModel() {
        return presenter.getViewModel();
    }
}
