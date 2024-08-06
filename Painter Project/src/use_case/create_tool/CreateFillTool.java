package use_case.create_tool;

import entity.tools.FillTool;
import entity.tools.FillToolFactory;

import java.awt.*;

public class CreateFillTool {
    /**
     * Creates a new fill tool with the specified color.
     *
     * @param color the color of the fill tool
     * @return the new fill tool
     */
    public FillTool create(Color color) {
        return FillToolFactory.create(color);
    }
}
