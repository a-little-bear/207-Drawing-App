package app;

import interface_adapter.Controller;
import interface_adapter.Mouse;
import interface_adapter.Presenter;
import interface_adapter.ViewModel;
import use_case.GetCanvasDimensions;
import use_case.InputBoundary;
import use_case.InputData;
import use_case.Interactor;
import use_case.OutputBoundary;
import view.View;
import view.ViewFactory;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        // Initialize the main program window
        JFrame window = new JFrame("Slumber:ZZZ");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(true);

        // Get canvas dimensions using the use case
        GetCanvasDimensions getCanvasDimensions = new GetCanvasDimensions();
        Dimension canvasDimensions = getCanvasDimensions.execute();

        // Set up the view model, presenter, interactor, controller,
        // and view panel for the window
        ViewModel viewModel = new ViewModel(canvasDimensions.width, canvasDimensions.height);
        OutputBoundary presenter = new Presenter(viewModel);
        Mouse mouse = new Mouse();
        InputData inputData = new InputData(mouse);
        InputBoundary interactor = new Interactor(presenter, inputData);
        Controller controller = new Controller(interactor, inputData, mouse);
        View view = ViewFactory.create(controller, viewModel);

        // Add the view panel to the window
        window.add(view);
        window.pack();

        // Run the thread and set the window to be visible
        new DrawingAppThread(view, controller);
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }
}
