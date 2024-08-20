package use_case.create_tool;

import entity.tool.EraserTool;
import entity.tool.EraserToolFactory;

import java.awt.*;

/**
 * The CreateEraserTool class implements the {@link CreateTool} interface for creating instances of {@link EraserTool}.
 * This class uses the {@link EraserToolFactory} to create and return a new EraserTool.
 */
public class CreateEraserTool implements CreateTool<EraserTool> {

    /**
     * Creates and returns a new instance of {@link EraserTool}.
     * The color parameter is not used in this implementation, as the eraser tool typically uses a default color.
     *
     * @param color The color to be used by the tool (not used for EraserTool).
     * @return A new instance of {@link EraserTool}.
     */
    public EraserTool create(Color color) {
        EraserToolFactory eraserToolFactory = new EraserToolFactory();
        return eraserToolFactory.create();
    }
}
