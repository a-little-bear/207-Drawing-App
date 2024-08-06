package interface_adapter;

import lombok.Getter;
import use_case.OutputBoundary;

public class Presenter implements OutputBoundary {
    @Getter private final ViewModel viewModel;

    /**
     * Instantiates a new Presenter with the specified view model.
     *
     * @param viewModel the view model to use
     */
    public Presenter(ViewModel viewModel) {
        this.viewModel = viewModel;
    }
}
