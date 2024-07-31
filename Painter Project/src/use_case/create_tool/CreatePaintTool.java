package use_case.create_tool;

import entity.tools.PaintTool;
import entity.tools.PaintToolFactory;

import java.awt.*;

public class CreatePaintTool implements CreateTool<PaintTool>{
    private CreatePaintTool(){}

    public PaintTool create(Color color){
        return PaintToolFactory.create(color);
    }
}
