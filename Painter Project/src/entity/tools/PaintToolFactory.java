package entity.tools;

import java.awt.*;

public class PaintToolFactory {
    private static final int size = 5;
    private static final boolean isDrawing = false;

    public static PaintTool create(Color color){
        PaintTool paintTool = new PaintTool();
        paintTool.setPaintColor(color);
        paintTool.setSize(size);
        paintTool.setIsDrawing(isDrawing);
        return paintTool;
    }
}
