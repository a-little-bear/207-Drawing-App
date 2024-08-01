package use_case.create_tool;

import entity.tools.Tool;

import java.awt.*;

public interface CreateTool<T extends Tool> {
    T create(Color color);
}
