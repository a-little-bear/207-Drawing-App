package interface_adapter;

import lombok.Getter;
import use_case.OutputBoundary;
import use_case.OutputData;

/**
 * The Presenter class implements the OutputBoundary interface and is responsible for
 * updating the view model based on the output data. It acts as an intermediary between
 * the application's output logic and the data that is displayed to the user.
 */
public class Presenter implements OutputBoundary {
    @Getter private final ViewModel viewModel;
    @Getter private final OutputData outputData;

    /**
     * Constructs a new Presenter with the specified view model and output data.
     *
     * @param viewModel  The view model that represents the data and state of the view.
     * @param outputData The output data that contains the current state of the application.
     */
    public Presenter(ViewModel viewModel, OutputData outputData) {
        this.viewModel = viewModel;
        this.outputData = outputData;
    }

    /**
     * Updates the canvas manager in the view model with the current canvas manager
     * from the output data.
     */
    public void updateCanvasManager() {
        this.viewModel.setCanvasManager(outputData.getCanvasManager());
    }

    /**
     * Updates the current tool in the view model with the current tool from the output data.
     */
    public void updateCurrentTool() {
        this.viewModel.setCurrentTool(outputData.getCurrentTool());
    }

    /**
     * Updates the current color in the view model with the current color from the output data.
     */
    public void updateCurrentColor() {
        this.viewModel.setActiveColor(outputData.getCurrentColor());
    }

    /**
     * Updates the view model with the latest data from the output data.
     * This method triggers updates for the canvas manager, current tool, and current color.
     */
    public void update() {
        updateCanvasManager();
        updateCurrentTool();
        updateCurrentColor();
    }
}
