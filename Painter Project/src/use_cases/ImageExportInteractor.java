package use_cases;

import main.View;

public class ImageExportInteractor implements  ImageExportInputBoundary {
    @Override
    public void exportImage(View view) {
        view.canvasManager.exportToPNG();
    }
}
