package entity.tool;

import java.awt.*;

/**
 * The FillToolFactory class provides a method for creating instances of the FillTool.
 */
public class FillToolFactory {

    private static final int size = 5;

    /**
     * Creates and initializes a new FillTool with the specified color.
     * The FillTool is initialized with a default size of 5.
     *
     * @param color The color to be used by the FillTool.
     * @return A newly created and initialized FillTool instance.
     */
    public static FillTool create(Color color){
        FillTool fillTool = new FillTool();
        fillTool.setPaintColor(color);
        fillTool.setSize(size);
        return fillTool;
    }
}
