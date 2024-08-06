package interface_adapter;

import lombok.Getter;
import use_case.OutputBoundary;

public class Presenter implements OutputBoundary {
    @Getter private final ViewModel viewModel;

    public Presenter(ViewModel viewModel) {
        this.viewModel = viewModel;
    }
}
