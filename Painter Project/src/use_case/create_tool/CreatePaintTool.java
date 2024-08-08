package use_case.create_tool;

import entity.tool.PaintTool;
import entity.tool.PaintToolFactory;

import java.awt.*;

public class CreatePaintTool implements CreateTool<PaintTool>{

    public PaintTool create(Color color){
        return PaintToolFactory.create(color);
    }
}
