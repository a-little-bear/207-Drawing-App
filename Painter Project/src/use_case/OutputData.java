package use_case;

import entity.canvas.CanvasManager;
import entity.tool.Tool;

import java.awt.*;
import lombok.Getter;

public class OutputData {
    @Getter private CanvasManager canvasManager;
    @Getter private Tool currentTool;
    @Getter private Color currentColor;

    public OutputData(CanvasManager canvasManager){
        this.canvasManager = canvasManager;
    }

    public void update(CanvasManager canvasManager, Tool currentTool, Color currentColor){
        this.canvasManager = canvasManager;
        this.currentTool = currentTool;
        this.currentColor = currentColor;
    }
}
