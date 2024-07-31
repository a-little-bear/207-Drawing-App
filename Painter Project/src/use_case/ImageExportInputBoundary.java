package use_case;

import entity.canvas.CanvasManager;
import view.View;

/**
 * The ImageExportInputBoundary interface defines a method for exporting an image from a view.
 */
public interface ImageExportInputBoundary {

    void exportImage(CanvasManager canvasManager);
}
