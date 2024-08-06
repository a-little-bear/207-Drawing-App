package entity;

import interface_adapter.ViewModel;
import lombok.Setter;

import java.awt.*;

/**
 * The Pixel class represents a pixel entity with a specific color and rendering state.
 */
public class Pixel extends Entity {

    ViewModel gp;
    @Setter Color color;
    Boolean rendered;

    /**
     * Instantiates a new Pixel with the specified view, coordinates, and color.
     *
     * @param gp    the view associated with this pixel
     * @param x     the x coordinate of the pixel
     * @param y     the y coordinate of the pixel
     * @param color the color of the pixel
     */
    public Pixel(ViewModel gp, int x, int y, Color color) {
        this.gp = gp;
        this.x = x;
        this.y = y;
        this.color = color;
        rendered = false;
    }

    /**
     * Sets the rendering state of the pixel.
     *
     * @param rendered the rendering state to set
     */
    public void render(boolean rendered) {
        this.rendered = rendered;
    }

    /**
     * Draws the pixel on the canvas if it is in the rendered state.
     *
     * @param g2 the Graphics2D object to draw on
     */
    public void draw(Graphics2D g2) {
        if (rendered) {
            g2.setColor(color);
            g2.fillRect(x, y, gp.tileSize, gp.tileSize);
        }
    }
}
