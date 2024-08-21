package use_case;

import entity.canvas.CanvasManager;
import entity.tool.Tool;

import java.awt.*;

/**
 * The InputBoundary interface defines the methods required for handling input-related operations
 * in the application. Implementing classes are responsible for managing interactions between
 * the user input, tools, and the canvas.
 */
public interface InputBoundary {

    /**
     * Retrieves the current color being used by the tool.
     *
     * @return The current {@link Color} selected for the tool.
     */
    Color getCurrentColor();

    /**
     * Switches the current tool to the specified tool.
     *
     * @param tool The new tool to be set as the current tool.
     * @param <T>  The type of the tool, which must extend {@link Tool}.
     */
    <T extends Tool> void switchTool(T tool);

    /**
     * Retrieves the presenter associated with this input boundary.
     *
     * @return The {@link OutputBoundary} presenter.
     */
    OutputBoundary getPresenter();

    /**
     * Updates the state of the input boundary, typically called to process user inputs
     * and update the associated view and model.
     */
    void update();

    /**
     * Retrieves the current tool being used.
     *
     * @return The current {@link Tool}.
     */
    Tool getCurrentTool();

    /**
     * Retrieves the input data containing the current state of the input devices (e.g., mouse, keyboard).
     *
     * @return The {@link InputData} containing the input state.
     */
    InputData getInputData();

    /**
     * Retrieves the current canvas manager that manages the canvas layers and drawing operations.
     *
     * @return The {@link CanvasManager}.
     */
    CanvasManager getCanvasManager();

    /**
     * Sets the canvas manager, replacing the current one.
     *
     * @param canvasManager The new {@link CanvasManager} to be set.
     */
    void setCanvasManager(CanvasManager canvasManager);

    /**
     * Initiates the LaTeX OCR (Optical Character Recognition) process, which converts drawn
     * text on the canvas to LaTeX code.
     */
    void latexOCR();
}
