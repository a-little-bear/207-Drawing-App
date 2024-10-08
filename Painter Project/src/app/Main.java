package app;

import entity.canvas.CanvasManager;
import entity.tool.Tool;
import interface_adapter.Controller;
import interface_adapter.Mouse;
import interface_adapter.Presenter;
import interface_adapter.ViewModel;
import toolbar.ToolbarFactory;
import use_case.*;
import use_case.create_tool.CreatePaintTool;
import use_case.create_tool.CreateTool;
import use_case.update_tool_size.DecreaseToolSizeAction;
import use_case.update_tool_size.IncreaseToolSizeAction;
import view.View;
import view.ViewFactory;

import toolbar.Toolbar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * The main entry point for the Drawing App. This class is responsible for initializing
 * and setting up all the core components of the application, including the view, controller,
 * toolbar, and the main application window.
 */
public class Main{
    private static final int scale = 1;
    public static final int tileSize = scale;
    public static final int maxScreenCol = 1280 / scale;
    private static final int screenWidth = tileSize * maxScreenCol;
    public static final int maxScreenRow = 720 / scale;
    private static final int screenHeight = tileSize * maxScreenRow;

    /**
     * The main method that serves as the entry point for the application.
     * This method sets up the application window, initializes the MVC components,
     * and starts the main drawing thread.
     *
     * @param args Command-line arguments
     */
    public static void main(String[] args) {
        // Initialize the main program window
        JFrame window = new JFrame("Drawing App");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(true);

        // Set up the view model, presenter, interactor, controller,
        // and view panel for the window
        CanvasManager canvasManager = new CanvasManager(screenWidth, screenHeight);
        CreateTool ct = new CreatePaintTool();
        Color currentColor = Color.BLACK;
        Tool currentTool = ct.create(currentColor);
        ViewModel viewModel = new ViewModel(currentTool, canvasManager);
        OutputData outputData = new OutputData(canvasManager);
        OutputBoundary presenter = new Presenter(viewModel, outputData);
        Mouse mouse = new Mouse();
        InputData inputData = new InputData(mouse, canvasManager, currentTool, currentColor);
        InputBoundary interactor = new Interactor(presenter, inputData, outputData);
        Controller controller = new Controller(interactor, inputData, mouse);
        View view = ViewFactory.create(controller, viewModel);

        view.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0), "up");
        view.getActionMap().put("up", new IncreaseToolSizeAction(interactor));
        view.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0), "down");
        view.getActionMap().put("down", new DecreaseToolSizeAction(interactor));

        ImageExportInputBoundary imageExportInteractor = new ImageExportInteractor();
        ToolbarFactory toolbarFactory = new ToolbarFactory(controller, inputData, interactor, imageExportInteractor);
        Toolbar toolbar = toolbarFactory.getToolbar();

        // Add the view panel to the window
        window.add(toolbar, BorderLayout.NORTH);
        window.add(view, BorderLayout.CENTER);
        window.pack();

        // Run the thread and set the window to be visible
        new DrawingAppThread(view, controller, presenter);
        window.setLocationRelativeTo(null);
        window.setVisible(true);
    }
}
