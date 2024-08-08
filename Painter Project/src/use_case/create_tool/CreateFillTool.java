package use_case.create_tool;

import entity.tool.FillTool;
import entity.tool.FillToolFactory;

import java.awt.*;

public class CreateFillTool implements CreateTool<FillTool>{

    @Override
    public FillTool create(Color color){
        return FillToolFactory.create(color);
    }
}
