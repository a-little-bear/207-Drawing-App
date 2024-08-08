package view;

import interface_adapter.Controller;
import interface_adapter.ViewModel;

import javax.swing.*;

public class ViewFactory {
    private ViewFactory(){}

    public static View create(Controller controller, ViewModel viewModel) {
        View view = new View(viewModel);
        view.addMouseListener(controller.getMouse());
        view.addMouseMotionListener(controller.getMouse());
        return view;
    }

}
