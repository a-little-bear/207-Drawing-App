package data_access;

import entity.canvas.Canvas;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * The DataAccessInterface provides methods for saving files.
 */
public interface DataAccessInterface {

    /**
     * Saves the provided image to a file, with a dialog box to specify the file name.
     *
     * @param dialogBoxTitle the title of the dialog box
     * @param image the image to be saved
     */
    void saveFile(String dialogBoxTitle, BufferedImage image);

    void exportFile(String dialogBoxTitle, ArrayList<Canvas> layers);
}
