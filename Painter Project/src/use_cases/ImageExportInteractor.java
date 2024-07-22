package use_cases;

import data_access.DataAccessObject;
import main.View;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.File;
import java.io.IOException;
import data_access.DataAccessObject;

public class ImageExportInteractor implements  ImageExportInputBoundary {
    private DataAccessObject dataAccessObject;

    public ImageExportInteractor(DataAccessObject dataAccessObject) {
        this.dataAccessObject = dataAccessObject;
    }

    @Override
    public void exportImage(View view) {
        dataAccessObject.saveFile("Specify a file to save", view.canvasManager.getCanvasImage());
    }
}
