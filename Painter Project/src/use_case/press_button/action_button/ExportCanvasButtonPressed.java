package use_case.press_button.action_button;

import use_case.InputBoundary;
import use_case.press_button.ButtonPressed;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.*;

/**
 * The ExportCanvasButtonPressed class extends the {@link ButtonPressed} class to handle
 * the action of exporting the current canvas to a file. When the export button is pressed,
 * this class prompts the user to select a file location and then saves the canvas layers
 * as a serialized object.
 */
public class ExportCanvasButtonPressed extends ButtonPressed {

    /**
     * Constructs an ExportCanvasButtonPressed instance with the specified interactor.
     * The interactor is used to interact with the canvas manager to retrieve the canvas layers.
     *
     * @param interactor The {@link InputBoundary} used to interact with the canvas manager.
     */
    public ExportCanvasButtonPressed(InputBoundary interactor) {
        super(interactor);
    }

    /**
     * Invoked when the export canvas button is pressed. This method prompts the user to select
     * a file location using a {@link JFileChooser} and then saves the current canvas layers as
     * a serialized object. It handles any IO exceptions that may occur during the saving process.
     *
     * @param e The {@link ActionEvent} triggered by the button press.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser fileChooser = new JFileChooser();
        int userSelection = fileChooser.showSaveDialog(null);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            // Get the selected file
            File fileToSave = fileChooser.getSelectedFile();

            // Check if the file has the .canvas extension
            if (!fileToSave.getName().toLowerCase().endsWith(".canvas")) {
                fileToSave = new File(fileToSave.getAbsolutePath() + ".canvas");
            }

            try (FileOutputStream fileOut = new FileOutputStream(fileToSave);
                 ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
                // Serialize the canvas object
                out.writeObject(super.getInteractor().getCanvasManager().getLayers());
                JOptionPane.showMessageDialog(null, "Canvas saved successfully!");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Error saving canvas: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
    }
}
