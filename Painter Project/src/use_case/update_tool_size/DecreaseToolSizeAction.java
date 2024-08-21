package use_case.update_tool_size;

import lombok.Getter;
import use_case.InputBoundary;

import javax.swing.*;
import java.awt.event.ActionEvent;

/**
 * The DecreaseToolSizeAction class implements the {@link AdjustToolSizeAction} interface and provides
 * the functionality to decrease the size of the current tool. It extends {@link AbstractAction},
 * allowing it to be used as an action in a Swing application.
 */
public class DecreaseToolSizeAction extends AbstractAction implements AdjustToolSizeAction {

    @Getter final InputBoundary interactor;

    /**
     * Constructs a DecreaseToolSizeAction with the specified interactor.
     * The interactor is used to access and modify the current tool's size.
     *
     * @param interactor The {@link InputBoundary} used to interact with the application's logic.
     */
    public DecreaseToolSizeAction(InputBoundary interactor) {
        this.interactor = interactor;
    }

    /**
     * Invoked when the decrease tool size action is performed. This method decreases the size
     * of the current tool by calling the {@code incrementSize} method with a negative value.
     *
     * @param e The {@link ActionEvent} triggered by the action.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        interactor.getCurrentTool().incrementSize(-1);
    }
}
