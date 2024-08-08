package use_case;

import interface_adapter.ViewModel;

public interface OutputBoundary {
    ViewModel getViewModel();

    void update();
}
