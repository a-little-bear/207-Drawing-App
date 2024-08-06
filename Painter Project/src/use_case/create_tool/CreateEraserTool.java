package use_case.create_tool;

import entity.tools.EraserTool;
import entity.tools.EraserToolFactory;

import java.awt.*;

public class CreateEraserTool implements CreateTool<EraserTool>{

    public EraserTool create(Color color){
        EraserToolFactory eraserToolFactory = new EraserToolFactory();
        return eraserToolFactory.create();
    }
}
