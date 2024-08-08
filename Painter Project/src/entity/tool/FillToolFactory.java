package entity.tool;

import java.awt.*;

public class FillToolFactory {

    private static final int size = 5;

    public static FillTool create(Color color){
        FillTool fillTool = new FillTool();
        fillTool.setPaintColor(color);
        fillTool.setSize(size);
        return fillTool;
    }
}
