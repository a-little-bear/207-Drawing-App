package use_case;

import data_access.DataAccessObject;
import entity.canvas.CanvasManager;

/**
 * The ImageExportInteractor class implements the ImageExportInputBoundary interface
 * and provides functionality to export images using a DataAccessObject.
 */
public class ImageExportInteractor implements ImageExportInputBoundary {
    private final DataAccessObject dataAccessObject;

    /**
     * Instantiates a new ImageExportInteractor with a DataAccessObject.
     */
    public ImageExportInteractor() {
        this.dataAccessObject = new DataAccessObject();
    }

    // Constructor to support testing
    public ImageExportInteractor(DataAccessObject dataAccessObject) {
        this.dataAccessObject = dataAccessObject;
    }

    /**
     * Exports the image from the provided view using the DataAccessObject.
     *
     * @param canvasManager The canvasManger where the saved image is being sourced from
     */
    @Override
    public void saveImage(CanvasManager canvasManager) {
        dataAccessObject.saveFile("Specify a file to save", canvasManager.getCanvasImage());
    }

    @Override
    public void exportCanvasManager(CanvasManager canvasManager) {
        dataAccessObject.exportFile("Specify a file to save", canvasManager.getLayers());
    }
}
