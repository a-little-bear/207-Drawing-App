package use_case.create_tool;

import entity.tool.PaintTool;
import entity.tool.PaintToolFactory;

import java.awt.*;

/**
 * The CreatePaintTool class implements the {@link CreateTool} interface for creating instances of {@link PaintTool}.
 * This class uses the {@link PaintToolFactory} to create and return a new PaintTool configured with the specified color.
 */
public class CreatePaintTool implements CreateTool<PaintTool> {

    /**
     * Creates and returns a new instance of {@link PaintTool} configured with the specified color.
     *
     * @param color The color to be used by the PaintTool.
     * @return A new instance of {@link PaintTool} with the specified color.
     */
    public PaintTool create(Color color) {
        return PaintToolFactory.create(color);
    }
}
