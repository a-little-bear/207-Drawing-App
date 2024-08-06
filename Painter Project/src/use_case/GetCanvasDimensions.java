package use_case;

import javax.swing.*;
import java.awt.Dimension;
/**
 * Prompts the user to enter the dimensions of the canvas.
 */
public class GetCanvasDimensions {
    private static final int MIN_DIMENSION = 100;
    private static final int MAX_DIMENSION = 5000;
    /**
     * Prompts the user to enter the dimensions of the canvas.
     * @return the dimensions of the canvas
     */
    public Dimension execute() {
        int width = 0;
        int height = 0;

        while (!isValidDimension(width) || !isValidDimension(height)) {
            String widthInput = JOptionPane.showInputDialog("Enter canvas width (" + MIN_DIMENSION + " - " + MAX_DIMENSION + "):");
            String heightInput = JOptionPane.showInputDialog("Enter canvas height (" + MIN_DIMENSION + " - " + MAX_DIMENSION + "):");

            try {
                width = Integer.parseInt(widthInput);
                height = Integer.parseInt(heightInput);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Please enter valid integers for dimensions.");
            }

            if (!isValidDimension(width) || !isValidDimension(height)) {
                JOptionPane.showMessageDialog(null, "Dimensions must be between " + MIN_DIMENSION + " and " + MAX_DIMENSION + ".");
            }
        }

        return new Dimension(width, height);
    }
    /**
     * Checks if the given dimension is valid.
     * @param dimension the dimension to check
     * @return true if the dimension is valid, false otherwise
     */
    private boolean isValidDimension(int dimension) {
        return dimension >= MIN_DIMENSION && dimension <= MAX_DIMENSION;
    }
}
