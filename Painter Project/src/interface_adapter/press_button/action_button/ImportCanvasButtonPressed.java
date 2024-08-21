package use_case.press_button.action_button;

import entity.canvas.Canvas;
import use_case.InputBoundary;
import use_case.press_button.ButtonPressed;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.*;
import java.util.ArrayList;

/**
 * The ImportCanvasButtonPressed class extends the {@link ButtonPressed} class to handle
 * the action of importing a canvas from a file. When the import button is pressed,
 * this class prompts the user to select a file, deserializes the canvas layers, and
 * updates the canvas manager with the imported layers.
 */
public class ImportCanvasButtonPressed extends ButtonPressed {

    /**
     * Constructs an ImportCanvasButtonPressed instance with the specified interactor.
     * The interactor is used to interact with the canvas manager to update the canvas layers.
     *
     * @param interactor The {@link InputBoundary} used to interact with the canvas manager.
     */
    public ImportCanvasButtonPressed(InputBoundary interactor) {
        super(interactor);
    }

    /**
     * Invoked when the import canvas button is pressed. This method prompts the user to select
     * a file using a {@link JFileChooser}, deserializes the canvas layers from the selected file,
     * and updates the canvas manager with the imported layers. It handles any IO exceptions or
     * class-not-found exceptions that may occur during the loading process.
     *
     * @param e The {@link ActionEvent} triggered by the button press.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser fileChooser = new JFileChooser();
        int userSelection = fileChooser.showOpenDialog(null);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            // Get the selected file
            File fileToOpen = fileChooser.getSelectedFile();

            try (FileInputStream fileIn = new FileInputStream(fileToOpen);
                 ObjectInputStream in = new ObjectInputStream(fileIn)) {

                // Deserialize the canvas object
                ArrayList<Canvas> layers = (ArrayList<Canvas>) in.readObject();

                // Set the deserialized canvas to the CanvasManager or use it as needed
                super.getInteractor().getCanvasManager().setLayers(layers);

                JOptionPane.showMessageDialog(null, "Canvas loaded successfully!");
            } catch (IOException | ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "Error loading canvas: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
    }
}
