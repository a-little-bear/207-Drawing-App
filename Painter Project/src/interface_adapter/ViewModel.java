package interface_adapter;

import entity.canvas.CanvasManager;
import entity.tools.PaintTool;
import entity.tools.Tool;
import lombok.Getter;
import lombok.Setter;
import use_case.create_tool.CreatePaintTool;
import use_case.create_tool.CreateTool;

import java.awt.*;

public class ViewModel {
    private final int scale = 1;
    public final int tileSize = scale;
    public final int maxScreenCol = 1920 / scale;
    private final int screenWidth = tileSize * maxScreenCol;
    public final int maxScreenRow = 1080 / scale;
    private final int screenHeight = tileSize * maxScreenRow;
    @Getter private final Color backgroundColor = Color.WHITE;
    @Getter private final CanvasManager canvasManager;
    @Getter @Setter private Tool currentTool;
    @Getter @Setter private Color activeColor = Color.BLACK;
    private final int width;
    private final int height;

    public ViewModel(int width, int height) {
        this.width = width;
        this.height = height;
        this.canvasManager = new CanvasManager(width, height);
        CreateTool<PaintTool> ct = new CreatePaintTool();
        this.currentTool = ct.create(activeColor);
    }

    public Dimension getDimension() {
        return new Dimension(width, height);
    }

    public void paint(Graphics2D g2) {
        canvasManager.draw(g2);
    }
}
