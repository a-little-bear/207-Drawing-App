package use_cases;

import data_access.DataAccessObject;
import kotlin.OverloadResolutionByLambdaReturnType;
import main.View;

public class ImageExportInteractor implements ImageExportInputBoundary {
    private DataAccessObject dataAccessObject;

    public ImageExportInteractor() {
        this.dataAccessObject = new DataAccessObject();
    }

    // Constructor to support testing
    public ImageExportInteractor(DataAccessObject dataAccessObject) {
        this.dataAccessObject = dataAccessObject;
    }

    @Override
    public void exportImage(View view) {
        dataAccessObject.saveFile("Specify a file to save", view.getCanvasManager().getCanvasImage());
    }
}
