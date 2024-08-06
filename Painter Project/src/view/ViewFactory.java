package view;

import interface_adapter.Controller;
import interface_adapter.ViewModel;

public class ViewFactory {
    private ViewFactory(){}

    /**
     * Creates a view with the given controller and view model.
     *
     * @param controller the controller
     * @param viewModel the view model
     * @return the view
     */
    public static View create(Controller controller, ViewModel viewModel){
        View view = new View(viewModel);
        view.addMouseListener(controller.getMouse());
        view.addMouseMotionListener(controller.getMouse());
        view.addKeyListener(controller.getKeyboard());
        return view;
    }
}
