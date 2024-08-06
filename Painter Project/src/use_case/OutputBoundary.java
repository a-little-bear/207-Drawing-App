package use_case;

import interface_adapter.ViewModel;

public interface OutputBoundary {
    /**
     * Updates the view model.
     */
    ViewModel getViewModel();
}
