package interface_adapter;

import entity.canvas.CanvasManager;
import entity.tools.PaintTool;
import entity.tools.Tool;
import lombok.Getter;
import lombok.Setter;
import use_case.create_tool.CreatePaintTool;

import java.awt.*;

public class ViewModel {
    private final int scale = 1;
    public final int tileSize = scale;
    public final int maxScreenCol = 1920 / scale;
    private final int screenWidth = tileSize * maxScreenCol;
    public final int maxScreenRow = 1080 / scale;
    private final int screenHeight = tileSize * maxScreenRow;
    @Getter private final Color backgroundColor = Color.WHITE;
    @Getter public CanvasManager canvasManager;
    @Getter @Setter public Tool currentTool;
    @Getter private Color activeColor = Color.BLACK;


    public ViewModel(){
        this.canvasManager = new CanvasManager(screenWidth, screenHeight);
        this.currentTool = new CreatePaintTool.create(activeColor);
    }

    public Dimension getDimension() {
        return new Dimension(screenWidth, screenHeight);
    }

    public void paint(Graphics2D g2) {
        // canvasManager.paint(g2);
        currentTool.paint(g2);
    }

}
