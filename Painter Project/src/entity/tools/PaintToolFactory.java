package entity.tools;

import java.awt.*;

public class PaintToolFactory {
    private static final int size = 5;
    private static final boolean isDrawing = false;

    /**
     * Creates a new paint tool with the specified color.
     *
     * @param color the color of the paint tool
     * @return the new paint tool
     */
    public static PaintTool create(Color color){
        PaintTool paintTool = new PaintTool();
        paintTool.setPaintColor(color);
        paintTool.setSize(size);
        paintTool.setIsDrawing(isDrawing);
        return paintTool;
    }
}
