package entity.tool;

import java.awt.*;

/**
 * The PaintToolFactory class provides a method for creating instances of the PaintTool.
 */
public class PaintToolFactory {
    private static final int size = 5;
    private static final boolean isDrawing = false;

    /**
     * Creates and initializes a new PaintTool with the specified color.
     * The PaintTool is initialized with a default size of 5 and the drawing state set to false.
     *
     * @param color The color to be used by the PaintTool.
     * @return A newly created and initialized PaintTool instance.
     */
    public static PaintTool create(Color color){
        PaintTool paintTool = new PaintTool();
        paintTool.setPaintColor(color);
        paintTool.setSize(size);
        paintTool.setIsDrawing(isDrawing);
        return paintTool;
    }
}
