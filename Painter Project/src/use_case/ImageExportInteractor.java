package use_case;

import data_access.DataAccessObject;
import entity.canvas.CanvasManager;

/**
 * The ImageExportInteractor class implements the {@link ImageExportInputBoundary} interface
 * and provides functionality to export images and canvas data using a {@link DataAccessObject}.
 */
public class ImageExportInteractor implements ImageExportInputBoundary {
    private final DataAccessObject dataAccessObject;

    /**
     * Constructs a new ImageExportInteractor with a default {@link DataAccessObject}.
     * This constructor is typically used in the main application.
     */
    public ImageExportInteractor() {
        this.dataAccessObject = new DataAccessObject();
    }

    /**
     * Constructs a new ImageExportInteractor with a specified {@link DataAccessObject}.
     * This constructor is typically used for testing purposes to allow for dependency injection.
     *
     * @param dataAccessObject The {@link DataAccessObject} used for saving and exporting files.
     */
    public ImageExportInteractor(DataAccessObject dataAccessObject) {
        this.dataAccessObject = dataAccessObject;
    }

    /**
     * Saves the current image from the provided {@link CanvasManager} using the {@link DataAccessObject}.
     * The user is prompted to specify a file name and location for saving the image.
     *
     * @param canvasManager The {@link CanvasManager} containing the image to be saved.
     */
    @Override
    public void saveImage(CanvasManager canvasManager) {
        dataAccessObject.saveFile("Specify a file to save", canvasManager.getCanvasImage());
    }

    /**
     * Exports the entire {@link CanvasManager}, including all layers, using the {@link DataAccessObject}.
     * The user is prompted to specify a file name and location for exporting the canvas manager data.
     *
     * @param canvasManager The {@link CanvasManager} to be exported.
     */
    @Override
    public void exportCanvasManager(CanvasManager canvasManager) {
        dataAccessObject.exportFile("Specify a file to save", canvasManager.getLayers());
    }
}
