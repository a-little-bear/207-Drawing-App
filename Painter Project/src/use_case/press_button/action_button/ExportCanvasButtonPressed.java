package use_case.press_button.action_button;

import use_case.InputBoundary;
import use_case.press_button.ButtonPressed;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.*;

public class ExportCanvasButtonPressed extends ButtonPressed {
    public ExportCanvasButtonPressed(InputBoundary interactor) {
        super(interactor);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser fileChooser = new JFileChooser();
        int userSelection = fileChooser.showSaveDialog(null);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            // Get the selected file
            File fileToSave = fileChooser.getSelectedFile();

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
