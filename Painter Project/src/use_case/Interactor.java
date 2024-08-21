package use_case;

import data_access.api.GoogleGeminiMathAPI;
import data_access.api.SimpleTexLatexAPI;
import entity.canvas.CanvasManager;
import entity.tool.Tool;
import lombok.Getter;
import use_case.update_tool.UpdateToolFacade;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.io.IOException;

/**
 * The Interactor class implements the {@link InputBoundary} interface and serves as the central
 * point for handling user inputs, tool interactions, and canvas updates within the application.
 * It also manages the flow of data between the input, output, and the various use cases.
 */
public class Interactor implements InputBoundary {

    @Getter private final OutputBoundary presenter;
    @Getter private final InputData inputData;
    @Getter private final OutputData outputData;

    /**
     * Constructs an Interactor with the specified presenter, input data, and output data.
     *
     * @param presenter  The {@link OutputBoundary} responsible for presenting the output.
     * @param inputData  The {@link InputData} containing the current state of user inputs.
     * @param outputData The {@link OutputData} that holds the data to be output.
     */
    public Interactor(OutputBoundary presenter, InputData inputData, OutputData outputData) {
        this.presenter = presenter;
        this.inputData = inputData;
        this.outputData = outputData;
    }

    /**
     * Retrieves the current color being used by the tool.
     *
     * @return The current {@link Color} selected for the tool.
     */
    public Color getCurrentColor() {
        return inputData.getCurrentColor();
    }

    /**
     * Switches the current tool to the specified tool.
     *
     * @param tool The new tool to be set as the current tool.
     * @param <T>  The type of the tool, which must extend {@link Tool}.
     */
    public <T extends Tool> void switchTool(T tool) {
        inputData.setCurrentTool(tool);
    }

    /**
     * Updates the current tool's behavior and the associated canvas, then updates the output data.
     */
    public void update() {
        UpdateToolFacade.update(inputData.getCurrentTool(), getInputData(), this);
        outputData.update(inputData.getCanvasManager(), inputData.getCurrentTool(), inputData.getCurrentColor());
    }

    /**
     * Retrieves the current {@link CanvasManager} that manages the canvas layers and drawing operations.
     *
     * @return The current {@link CanvasManager}.
     */
    public CanvasManager getCanvasManager() {
        return inputData.getCanvasManager();
    }

    /**
     * Sets the {@link CanvasManager} to the specified instance.
     *
     * @param canvasManager The {@link CanvasManager} to be set.
     */
    public void setCanvasManager(CanvasManager canvasManager) {
        inputData.setCanvasManager(canvasManager);
    }

    /**
     * Retrieves the current tool being used.
     *
     * @return The current {@link Tool}.
     */
    public Tool getCurrentTool() {
        return inputData.getCurrentTool();
    }

    /**
     * Retrieves the input data containing the current state of user inputs.
     *
     * @return The {@link InputData}.
     */
    public InputData getInputData() {
        return inputData;
    }

    /**
     * Performs OCR (Optical Character Recognition) on the canvas image and displays the LaTeX code result in a dialog box.
     * The result is also copied to the system clipboard. Optionally, the user can send the LaTeX code to Google Gemini
     * for further analysis and receive a response.
     */
    public void latexOCR() {
        String latexResponse = new SimpleTexLatexAPI().OCR(inputData.getCanvasManager().collapseLayers().getCanvasImage());

        // Copy to clipboard
        StringSelection selection = new StringSelection(latexResponse);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(selection, selection);

        // Show LaTeX code in a dialog
        JOptionPane.showMessageDialog(null, latexResponse, "OCR Result", JOptionPane.INFORMATION_MESSAGE);

        // Ask user if they want to send the LaTeX code to Google Gemini for analysis
        int result = JOptionPane.showConfirmDialog(null,
                "Do you want to send the LaTeX code to Google Gemini for analysis?",
                "Send to Google Gemini",
                JOptionPane.YES_NO_OPTION);

        // If user selected "Yes", send the LaTeX code to Google Gemini and show the response
        if (result == JOptionPane.YES_OPTION) {
            String geminiResponse;
            try {
                geminiResponse = new GoogleGeminiMathAPI().solveEquation(latexResponse);
            } catch (IOException e) {
                geminiResponse = "Failed to get response from Gemini:\n" + e.toString();
            }
            JOptionPane.showMessageDialog(null, geminiResponse, "Gemini Response", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
