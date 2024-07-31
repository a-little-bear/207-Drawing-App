package entity.tools;

import java.awt.*;

public class EraserToolFactory {

    public static EraserTool create(){
        EraserTool eraserTool = new EraserTool();
        eraserTool.setPaintColor(Color.WHITE); // TODO: GET TRANSPARENT TO WORK INSTEAD OF WHITE
        eraserTool.setSize(20);
        eraserTool.setIsDrawing(false);
        return eraserTool;
    }
}
