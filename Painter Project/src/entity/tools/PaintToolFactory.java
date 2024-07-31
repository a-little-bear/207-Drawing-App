package entity.tools;

import java.awt.*;

public class PaintToolFactory {
    private final int size = 5;
    private final boolean isDrawing = false;

    private PaintToolFactory(){}

    public static PaintTool create(Color color){
        PaintTool paintTool = new PaintTool();
        paintTool.setColor(color);
        paintTool.setSize(size);
        paintTool.setIsDrawing(isDrawing);
        return paintTool;
    }
}
