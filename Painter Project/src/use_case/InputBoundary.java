package use_case;

import entity.canvas.CanvasManager;
import entity.tool.Tool;
import interface_adapter.ViewModel;

import java.awt.*;

public interface InputBoundary{
    Color getCurrentColor();

    <T extends Tool> void switchTool(T tool);

    OutputBoundary getPresenter();

    void update();

    Tool getCurrentTool();

    InputData getInputData();

    CanvasManager getCanvasManager();

    void setCanvasManager(CanvasManager canvasManager);

    void latexOCR();
}
