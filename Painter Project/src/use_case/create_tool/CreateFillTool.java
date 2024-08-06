package use_case.create_tool;

import entity.tools.FillTool;
import entity.tools.FillToolFactory;
import entity.tools.PaintTool;
import entity.tools.PaintToolFactory;

import java.awt.*;

public class CreateFillTool implements CreateTool<FillTool>{

    @Override
    public FillTool create(Color color){
        return FillToolFactory.create(color);
    }
}
