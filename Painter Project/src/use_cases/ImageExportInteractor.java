package use_cases;

import data_access.DataAccessObject;
import main.View;

/**
 * The ImageExportInteractor class implements the ImageExportInputBoundary interface
 * and provides functionality to export images using a DataAccessObject.
 */
public class ImageExportInteractor implements ImageExportInputBoundary {
    private DataAccessObject dataAccessObject;

    /**
     * Instantiates a new ImageExportInteractor with a DataAccessObject.
     */
    public ImageExportInteractor() {
        this.dataAccessObject = new DataAccessObject();
    }

    /**
     * Exports the image from the provided view using the DataAccessObject.
     *
     * @param view the view containing the image to be exported
     */
    @Override
    public void exportImage(View view) {
        dataAccessObject.saveFile("Specify a file to save", view.canvasManager.getCanvasImage());
    }
}
