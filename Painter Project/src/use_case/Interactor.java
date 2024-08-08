package use_case;

import data_access.api.SimpleTexLatexAPI;
import entity.canvas.CanvasManager;
import entity.tool.Tool;
import interface_adapter.ViewModel;
import lombok.Getter;
import use_case.update_tool.UpdateToolFacade;

import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

public class Interactor implements InputBoundary{
    @Getter private final OutputBoundary presenter;
    @Getter private final InputData inputData;
    @Getter private final OutputData outputData;

    public Interactor(OutputBoundary presenter, InputData inputData, OutputData outputData) {
        this.presenter = presenter;
        this.inputData = inputData;
        this.outputData = outputData;
    }

    public Color getCurrentColor(){
        return inputData.getCurrentColor();
    }

    public <T extends Tool> void switchTool(T tool){
        inputData.setCurrentTool(tool);
    }

    public void update(){
        UpdateToolFacade.update(inputData.getCurrentTool(),
                getInputData(), this);
        outputData.update(inputData.getCanvasManager(), inputData.getCurrentTool(), inputData.getCurrentColor());
    }

    public CanvasManager getCanvasManager(){
        return inputData.getCanvasManager();
    }

    public Tool getCurrentTool(){
        return inputData.getCurrentTool();
    }

    public InputData getInputData(){
        return inputData;
    }

    /**
     * Performs OCR on the canvas image and displays the result in a dialog box.
     */
    public void latexOCR() {
        String response = new SimpleTexLatexAPI().OCR(inputData.getCanvasManager().collapseLayers().getCanvasImage());

        // copy to clipboard
        StringSelection selection = new StringSelection(response);
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        clipboard.setContents(selection, selection);

        // pop up the latex code
        JOptionPane.showMessageDialog(null, response, "OCR Result", JOptionPane.INFORMATION_MESSAGE);

    }

}
