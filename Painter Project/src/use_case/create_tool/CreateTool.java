package use_case.create_tool;

import entity.tools.Tool;

import java.awt.*;

public interface CreateTool<T extends Tool> {

    /**
     * Creates a new tool with the specified color.
     *
     * @param color the color of the tool
     * @return the new tool
     */
    T create(Color color);
}
