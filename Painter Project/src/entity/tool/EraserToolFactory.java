package entity.tool;

import java.awt.*;

public class EraserToolFactory {

    public static EraserTool create(){
        EraserTool eraserTool = new EraserTool();
        eraserTool.setPaintColor(new Color(0,0,0,0));
        eraserTool.setSize(20);
        eraserTool.setIsDrawing(false);
        return eraserTool;
    }
}
