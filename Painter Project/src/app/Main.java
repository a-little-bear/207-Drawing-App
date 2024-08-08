package app;

import interface_adapter.Controller;
import interface_adapter.Mouse;
import interface_adapter.Presenter;
import interface_adapter.ViewModel;
import use_case.*;
import view.View;
import view.ViewFactory;

import toolbar.Toolbar;

import javax.swing.*;
import java.awt.*;

public class Main{
    public static void main(String[] args) {
        // Initialize the main program window
        JFrame window = new JFrame("Drawing App");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(true);

        // Set up the view model, presenter, interactor, controller,
        // and view panel for the window
        ViewModel viewModel = new ViewModel();
        OutputBoundary presenter = new Presenter(viewModel);
        Mouse mouse = new Mouse();
        InputData inputData = new InputData(mouse);
        InputBoundary interactor = new Interactor(presenter, inputData);
        Controller controller = new Controller(interactor, inputData, mouse);
        View view = ViewFactory.create(controller, viewModel);

        ImageExportInputBoundary imageExportInteractor = new ImageExportInteractor();
        Toolbar toolbar = new Toolbar(interactor, imageExportInteractor);

        // Add the view panel to the window
        window.add(toolbar, BorderLayout.NORTH);
        window.add(view, BorderLayout.CENTER);
        window.pack();

        // Run the thread and set the window to be visible
        new DrawingAppThread(view, controller);
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }
}
