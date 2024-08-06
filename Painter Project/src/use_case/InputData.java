package use_case;

import interface_adapter.Mouse;
import lombok.Getter;
import lombok.Setter;

public class InputData {
    @Getter @Setter private int xCoord;
    @Getter @Setter private int yCoord;
    @Getter @Setter private int lastXCoord;
    @Getter @Setter private int lastYCoord;
    @Getter @Setter private boolean mouseIsActive;

    /**
     * Instantiates a new Input data.
     *
     * @param keyboard the keyboard
     */
    public InputData(Mouse mouse){
        this.xCoord = mouse.xCoord;
        this.yCoord = mouse.yCoord;
        this.lastXCoord = mouse.xCoord;
        this.lastYCoord = mouse.yCoord;
        this.mouseIsActive = mouse.isActive;
    }

    /**
     * Updates the input data with the current mouse data.
     *
     * @param mouse the mouse
     */
    public void updateMouse(Mouse mouse){
        this.xCoord = mouse.xCoord;
        this.yCoord = mouse.yCoord;
        this.mouseIsActive = mouse.isActive;
    }

    /**
     * Updates the input data with the current keyboard data.
     *
     * @param keyboard the keyboard
     */
    public boolean getMouseIsActive() {
        return mouseIsActive;
    }
}
