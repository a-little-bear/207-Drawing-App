package use_case;

import entity.canvas.CanvasManager;
import entity.tool.Tool;
import interface_adapter.Mouse;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;

public class InputData {
    @Getter @Setter private int xCoord;
    @Getter @Setter private int yCoord;
    @Getter @Setter private int lastXCoord;
    @Getter @Setter private int lastYCoord;
    @Getter @Setter private boolean mouseIsActive;
    private final CanvasManager canvasManager;
    @Getter @Setter private Tool currentTool;
    @Getter @Setter private Color currentColor;

    public InputData(Mouse mouse, CanvasManager canvasManager, Tool currentTool, Color currentColor){
        this.xCoord = mouse.xCoord;
        this.yCoord = mouse.yCoord;
        this.lastXCoord = mouse.xCoord;
        this.lastYCoord = mouse.yCoord;
        this.mouseIsActive = mouse.isActive;
        this.canvasManager = canvasManager;
        this.currentTool = currentTool;
        this.currentColor = currentColor;
    }

    public void updateMouse(Mouse mouse){
        this.xCoord = mouse.xCoord;
        this.yCoord = mouse.yCoord;
        this.mouseIsActive = mouse.isActive;
    }

    public boolean getMouseIsActive() {
        return mouseIsActive;
    }

    public CanvasManager getCanvasManager(){
        return canvasManager;
    }
}
