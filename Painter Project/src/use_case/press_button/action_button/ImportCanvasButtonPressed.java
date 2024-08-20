package use_case.press_button.action_button;

import entity.canvas.Canvas;
import entity.canvas.CanvasManager;
import use_case.InputBoundary;
import use_case.press_button.ButtonPressed;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.*;
import java.util.ArrayList;

public class ImportCanvasButtonPressed extends ButtonPressed {
    public ImportCanvasButtonPressed(InputBoundary interactor) {
        super(interactor);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser fileChooser = new JFileChooser();
        int userSelection = fileChooser.showOpenDialog(null);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            // Get the selected file
            java.io.File fileToOpen = fileChooser.getSelectedFile();

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
