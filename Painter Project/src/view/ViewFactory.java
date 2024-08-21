package view;

import interface_adapter.Controller;
import interface_adapter.ViewModel;

/**
 * The ViewFactory class provides a static factory method to create instances of the {@link View} class.
 * It sets up the view with the necessary {@link Controller} and {@link ViewModel} to manage user interactions
 * and render the application's state.
 */
public class ViewFactory {

    /**
     * Private constructor to prevent instantiation of this utility class.
     * The ViewFactory is intended to be used through its static methods only.
     */
    private ViewFactory() {}

    /**
     * Creates and configures a new {@link View} instance with the specified {@link Controller} and {@link ViewModel}.
     * The view is set up with mouse listeners provided by the controller to handle user input.
     *
     * @param controller The {@link Controller} that manages user input and interaction with the view.
     * @param viewModel  The {@link ViewModel} that provides the state and properties for rendering the view.
     * @return A configured {@link View} instance ready for use in the application.
     */
    public static View create(Controller controller, ViewModel viewModel) {
        View view = new View(viewModel);
        view.addMouseListener(controller.getMouse());
        view.addMouseMotionListener(controller.getMouse());
        return view;
    }
}
