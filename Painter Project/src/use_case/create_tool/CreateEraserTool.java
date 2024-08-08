package use_case.create_tool;

import entity.tool.EraserTool;
import entity.tool.EraserToolFactory;

import java.awt.*;

public class CreateEraserTool implements CreateTool<EraserTool>{

    public EraserTool create(Color color){
        EraserToolFactory eraserToolFactory = new EraserToolFactory();
        return eraserToolFactory.create();
    }
}
