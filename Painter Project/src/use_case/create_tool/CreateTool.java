package use_case.create_tool;

import entity.tool.Tool;

import java.awt.*;

/**
 * The CreateTool interface defines a method for creating instances of tools used in the application.
 * It is a generic interface that can be implemented to create different types of tools, such as paint tools,
 * erasers, and fill tools.
 *
 * @param <T> The type of tool that this interface will create. It must extend the {@link Tool} interface.
 */
public interface CreateTool<T extends Tool> {

    /**
     * Creates and returns a new instance of a tool configured with the specified color.
     *
     * @param color The color to be used by the tool.
     * @return A new instance of the tool configured with the specified color.
     */
    T create(Color color);
}
