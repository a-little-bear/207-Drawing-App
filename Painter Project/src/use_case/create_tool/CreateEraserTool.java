package use_case.create_tool;

import entity.tools.EraserTool;
import entity.tools.EraserToolFactory;

import java.awt.*;

public class CreateEraserTool implements CreateTool<EraserTool>{

    /**
     * Creates a new eraser tool with the specified color.
     *
     * @param color the color of the eraser tool
     * @return the new eraser tool
     */
    public EraserTool create(Color color){
        return EraserToolFactory.create();
    }
}
