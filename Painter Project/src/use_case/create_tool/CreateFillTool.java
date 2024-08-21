package use_case.create_tool;

import entity.tool.FillTool;
import entity.tool.FillToolFactory;

import java.awt.*;

/**
 * The CreateFillTool class implements the {@link CreateTool} interface for creating instances of {@link FillTool}.
 * This class uses the {@link FillToolFactory} to create and return a new FillTool configured with the specified color.
 */
public class CreateFillTool implements CreateTool<FillTool> {

    /**
     * Creates and returns a new instance of {@link FillTool} configured with the specified color.
     *
     * @param color The color to be used by the FillTool.
     * @return A new instance of {@link FillTool} with the specified color.
     */
    @Override
    public FillTool create(Color color) {
        return FillToolFactory.create(color);
    }
}
