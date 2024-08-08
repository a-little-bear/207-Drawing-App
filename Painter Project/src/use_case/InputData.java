package use_case;

import entity.canvas.CanvasManager;
import interface_adapter.Mouse;
import lombok.Getter;
import lombok.Setter;

public class InputData {
    @Getter @Setter private int xCoord;
    @Getter @Setter private int yCoord;
    @Getter @Setter private int lastXCoord;
    @Getter @Setter private int lastYCoord;
    @Getter @Setter private boolean mouseIsActive;
    private final CanvasManager canvasManager;

    public InputData(Mouse mouse, CanvasManager canvasManager){
        this.xCoord = mouse.xCoord;
        this.yCoord = mouse.yCoord;
        this.lastXCoord = mouse.xCoord;
        this.lastYCoord = mouse.yCoord;
        this.mouseIsActive = mouse.isActive;
        this.canvasManager = canvasManager;
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
