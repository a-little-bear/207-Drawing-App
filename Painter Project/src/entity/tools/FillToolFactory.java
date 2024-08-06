package entity.tools;

import java.awt.*;

public class FillToolFactory {

    private static final int size = 5;

    /**
     * Creates a new fill tool with the specified color.
     *
     * @param color the color of the fill tool
     * @return the new fill tool
     */
    public static FillTool create(Color color){
        FillTool fillTool = new FillTool();
        fillTool.setPaintColor(color);
        fillTool.setSize(size);
        return fillTool;
    }
}
