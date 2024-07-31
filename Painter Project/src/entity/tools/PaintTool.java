package entity.tools;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;

/**
 * The PaintTool class implements the Tool interface and provides functionality
 * for painting on the canvas with a specified color and size.
 */
public class PaintTool implements Tool {
    @Setter(AccessLevel.PROTECTED) @Getter private int size;
    @Setter(AccessLevel.PROTECTED) @Getter private Color color;
    @Setter(AccessLevel.PROTECTED) @Getter private boolean isDrawing;

    private int lastX, lastY;

    /**
     * Draws the paint tool cursor on the canvas.
     *
     * @param g2 the Graphics2D object to draw on
     */
    public void draw(Graphics2D g2) {
        int x = controller.mouse.xCoord;
        int y = controller.mouse.yCoord;
        g2.setColor(color);
        g2.fillRect(x, y, size, size); // Updated to use size directly
    }

    /**
     * Increments the size of the paint tool.
     *
     * @param increment the amount to increment the size by
     */
    public void incrementSize(int increment) {
        if (size < 1) {
            size = 1;
        } else {
            size += increment;
        }
    }
}
