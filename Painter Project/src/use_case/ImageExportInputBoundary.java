package use_case;

import entity.canvas.CanvasManager;

/**
 * The ImageExportInputBoundary interface defines methods for exporting an image or canvas manager.
 * Implementing classes are responsible for providing the logic to save an image or export the entire
 * canvas manager to a file or another output format.
 */
public interface ImageExportInputBoundary {

    /**
     * Saves the current image from the canvas manager to a file or another output format.
     *
     * @param canvasManager The {@link CanvasManager} containing the image to be saved.
     */
    void saveImage(CanvasManager canvasManager);

    /**
     * Exports the entire canvas manager, including all layers and relevant data, to a file
     * or another output format.
     *
     * @param canvasManager The {@link CanvasManager} to be exported.
     */
    void exportCanvasManager(CanvasManager canvasManager);
}
