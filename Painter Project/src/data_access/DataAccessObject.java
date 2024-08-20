package data_access;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import entity.canvas.Canvas;

/**
 * The DataAccessObject class implements the DataAccessInterface to provide functionality
 * for saving images to files.
 */
public class DataAccessObject implements DataAccessInterface {

    private final JFileChooser fileChooser;

    /**
     * Default constructor that initializes the DataAccessObject with a file chooser
     * set to the user's current working directory.
     */
    public DataAccessObject() {
        this.fileChooser = new JFileChooser(new File(System.getProperty("user.dir")));
    }

    /**
     * Saves the provided image to a file. The user is prompted with a dialog box
     * to specify the file name and location. If the file name does not end with
     * ".png", the extension is automatically added.
     *
     * @param dialogBoxTitle The title of the dialog box.
     * @param image The image to be saved.
     */
    @Override
    public void saveFile(String dialogBoxTitle, BufferedImage image) {
        fileChooser.setDialogTitle(dialogBoxTitle);
        int userSelection = fileChooser.showSaveDialog(null);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();

            if (!file.getAbsolutePath().endsWith(".png")) {
                file = new File(file.getAbsolutePath() + ".png");
            }

            try {
                ImageIO.write(image, "png", file);
            } catch (IOException | NullPointerException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Exports the provided list of canvas layers to a file. The user is prompted
     * with a dialog box to specify the file name and location. If the file name does
     * not end with ".canvas", the extension is automatically added.
     *
     * @param dialogBoxTitle The title of the dialog box.
     * @param layers The layers of the canvas to be exported.
     */
    @Override
    public void exportFile(String dialogBoxTitle, ArrayList<Canvas> layers) {
        fileChooser.setDialogTitle(dialogBoxTitle);
        int userSelection = fileChooser.showSaveDialog(null);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();

            if (!file.getAbsolutePath().endsWith(".canvas")) {
                file = new File(file.getAbsolutePath() + ".canvas");
            }

            try {
                FileOutputStream fos = new FileOutputStream(file);
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(layers);

                oos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
