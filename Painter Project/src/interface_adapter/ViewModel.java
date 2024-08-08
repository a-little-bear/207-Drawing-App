package interface_adapter;

import entity.canvas.CanvasManager;
import entity.tools.Tool;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;

public class ViewModel {
    @Getter private final Color backgroundColor = Color.WHITE;
    @Getter @Setter public Tool currentTool;
    @Getter @Setter private Color activeColor = Color.BLACK;
    private int screenWidth;
    private int screenHeight;
    private CanvasManager canvasManager;

    public ViewModel(Tool tool, CanvasManager canvasManager) {
        this.currentTool = tool;
        this.canvasManager = canvasManager;
        this.screenWidth = canvasManager.getDimension().width;
        this.screenHeight = canvasManager.getDimension().height;
    }

    public Dimension getDimension() {
        return new Dimension(screenWidth, screenHeight);
    }

    public void setCanvasManager(CanvasManager canvasManager) {
        this.canvasManager = canvasManager;
    }

    public void paint(Graphics2D g){
        canvasManager.draw(g);
    }
}
