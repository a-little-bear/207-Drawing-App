package interface_adapter;

import lombok.Getter;
import use_case.OutputBoundary;
import use_case.OutputData;

public class Presenter implements OutputBoundary {
    @Getter private final ViewModel viewModel;
    @Getter private final OutputData outputData;

    public Presenter(ViewModel viewModel, OutputData outputData) {
        this.viewModel = viewModel;
        this.outputData = outputData;
    }

    public void updateCanvasManager() {
        this.viewModel.setCanvasManager(outputData.getCanvasManager());
    }

    public void updateCurrentTool() {
        this.viewModel.setCurrentTool(outputData.getCurrentTool());
    }

    public void updateCurrentColor() {
        this.viewModel.setActiveColor(outputData.getCurrentColor());
    }

    public void update() {
        updateCanvasManager();
        updateCurrentTool();
        updateCurrentColor();
    }
}
