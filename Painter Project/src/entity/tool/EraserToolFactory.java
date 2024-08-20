package entity.tool;

import java.awt.*;

/**
 * The EraserToolFactory class provides a method for creating instances of the EraserTool.
 */
public class EraserToolFactory {

    /**
     * Creates and initializes a new EraserTool with default settings.
     * The default settings include a transparent color, a size of 20, and
     * the drawing state set to false (not drawing).
     *
     * @return A newly created and initialized EraserTool instance.
     */
    public static EraserTool create(){
        EraserTool eraserTool = new EraserTool();
        eraserTool.setPaintColor(new Color(0,0,0,0));
        eraserTool.setSize(20);
        eraserTool.setIsDrawing(false);
        return eraserTool;
    }
}
