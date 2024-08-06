package use_case.create_tool;

import entity.tools.PaintTool;
import entity.tools.PaintToolFactory;

import java.awt.*;

public class CreatePaintTool implements CreateTool<PaintTool>{

    /**
     * Creates a new paint tool with the specified color.
     *
     * @param color the color of the paint tool
     * @return the new paint tool
     */
    public PaintTool create(Color color){
        return PaintToolFactory.create(color);
    }
}
