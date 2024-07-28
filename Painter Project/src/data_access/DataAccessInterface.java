package data_access;

import java.awt.image.BufferedImage;

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
}
