package data_access;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class DataAccessObject implements DataAccessInterface {

    private final JFileChooser fileChooser;
    // Constructor for testing purposes
    public DataAccessObject() {
        this.fileChooser = new JFileChooser();
    }
    // Constructor for testing purposes
    public DataAccessObject(JFileChooser fileChooser) {
        this.fileChooser = fileChooser;
    }

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
}
