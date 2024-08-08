package app;

import entity.canvas.CanvasManager;
import interface_adapter.Controller;
import interface_adapter.Mouse;
import interface_adapter.Presenter;
import interface_adapter.ViewModel;
import use_case.*;
import use_case.create_tool.CreatePaintTool;
import use_case.create_tool.CreateTool;
import view.View;
import view.ViewFactory;

import entity.toolbar.Toolbar;

import javax.swing.*;
import java.awt.*;

public class Main{
    private static final int scale = 1;
    public static final int tileSize = scale;
    public static final int maxScreenCol = 1280 / scale;
    private static final int screenWidth = tileSize * maxScreenCol;
    public static final int maxScreenRow = 720 / scale;
    private static final int screenHeight = tileSize * maxScreenRow;

    public static void main(String[] args) {
        // Initialize the main program window
        JFrame window = new JFrame("Slumber:ZZZ");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(true);

        // Set up the view model, presenter, interactor, controller,
        // and view panel for the window
        CanvasManager canvasManager = new CanvasManager(screenWidth, screenHeight);
        CreateTool ct = new CreatePaintTool();
        ViewModel viewModel = new ViewModel(ct.create(Color.BLACK), canvasManager);
        OutputData outputData = new OutputData(canvasManager);
        OutputBoundary presenter = new Presenter(viewModel, outputData);
        Mouse mouse = new Mouse();
        InputData inputData = new InputData(mouse, canvasManager);
        InputBoundary interactor = new Interactor(presenter, inputData, outputData);
        Controller controller = new Controller(interactor, inputData, mouse);
        View view = ViewFactory.create(controller, viewModel);

        ImageExportInputBoundary imageExportInteractor = new ImageExportInteractor();
        Toolbar toolbar = new Toolbar(interactor, imageExportInteractor);

        // Add the view panel to the window
        window.add(toolbar);
        window.add(view);
        window.pack();

        // Run the thread and set the window to be visible
        new DrawingAppThread(view, controller, presenter);
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }
}
