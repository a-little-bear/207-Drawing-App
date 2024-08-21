package data_access;

import entity.canvas.Canvas;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * The DataAccessInterface provides methods for saving files.
 */
public interface DataAccessInterface {

    /**
     * Saves the provided image to a file, displaying a dialog box for the user to specify the file name.
     *
     * @param dialogBoxTitle The title of the dialog box that prompts the user to specify the file name.
     * @param image The image to be saved.
     */
    void saveFile(String dialogBoxTitle, BufferedImage image);

    /**
     * Exports the provided layers of a canvas to a file, displaying a dialog box for the user to specify the file name.
     *
     * @param dialogBoxTitle The title of the dialog box that prompts the user to specify the file name.
     * @param layers The layers of the canvas to be exported.
     */
    void exportFile(String dialogBoxTitle, ArrayList<Canvas> layers);
}
