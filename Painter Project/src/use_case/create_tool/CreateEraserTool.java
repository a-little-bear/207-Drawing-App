package use_case.create_tool;

import entity.tools.EraserTool;

import java.awt.*;

public class CreateEraserTool implements CreateTool<EraserTool>{
    private CreateEraserTool(){}

    public EraserTool create(Color color){
        return EraserToolFactory.create(color);
    }
}
