package use_case;

import entity.canvas.CanvasManager;

/**
 * The ImageExportInputBoundary interface defines a method for exporting an image from a view.
 */
public interface ImageExportInputBoundary {

    void saveImage(CanvasManager canvasManager);

    void exportCanvasManager(CanvasManager canvasManager);
}
