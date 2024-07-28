package use_cases;

import main.View;

/**
 * The ImageExportInputBoundary interface defines a method for exporting an image from a view.
 */
public interface ImageExportInputBoundary {

    /**
     * Exports the image from the provided view.
     *
     * @param view the view containing the image to be exported
     */
    void exportImage(View view);
}
