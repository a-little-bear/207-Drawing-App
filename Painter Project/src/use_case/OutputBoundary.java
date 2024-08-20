package use_case;

import interface_adapter.ViewModel;

/**
 * The OutputBoundary interface defines the methods required for updating the view model
 * and facilitating the presentation logic within the application. Implementing classes
 * are responsible for managing how data is presented to the user.
 */
public interface OutputBoundary {

    /**
     * Retrieves the view model that represents the state of the application's UI.
     *
     * @return The {@link ViewModel} that encapsulates the UI state.
     */
    ViewModel getViewModel();

    /**
     * Updates the view model with the latest data, ensuring that the UI reflects
     * the current state of the application.
     */
    void update();
}
