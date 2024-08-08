package use_case;

import entity.canvas.CanvasManager;

public class OutputData {
    private CanvasManager canvasManager;

    public OutputData(CanvasManager canvasManager){
        this.canvasManager = canvasManager;
    }

    public void update(CanvasManager canvasManager){
        this.canvasManager = canvasManager;
    }

    public CanvasManager getCanvasManager(){
        return canvasManager;
    }
}
