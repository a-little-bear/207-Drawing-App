package use_case;

import data_access.api.SimpleTexLatexAPI;
import entity.canvas.CanvasManager;
import entity.tools.Tool;
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
        return (Color) presenter.getViewModel().getActiveColor();
    }

    public <T extends Tool> void switchTool(T tool){
        presenter.getViewModel().setCurrentTool(tool);
    }

    public void update(){
        UpdateToolFacade.update(presenter.getViewModel().getCurrentTool(),
                getInputData(), this);
        outputData.update(inputData.getCanvasManager());
    }

    @Override
    public ViewModel getViewModel() {
        return presenter.getViewModel();
    }

    public CanvasManager getCanvasManager(){
        return inputData.getCanvasManager();
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
