package use_case;

import entity.canvas.CanvasManager;

/**
 * The ImageExportInputBoundary interface defines a method for exporting an image from a view.
 */
public interface ImageExportInputBoundary {

    /**
     * Exports the image from the view.
     *
     * @param canvasManager the canvas manager
     */
    void exportImage(CanvasManager canvasManager);
}
