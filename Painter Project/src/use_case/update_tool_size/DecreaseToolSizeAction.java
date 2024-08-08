package use_case.update_tool_size;

import lombok.Getter;
import use_case.InputBoundary;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class DecreaseToolSizeAction extends AbstractAction {
    @Getter final InputBoundary interactor;

    public DecreaseToolSizeAction(InputBoundary interactor) {
        this.interactor = interactor;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        interactor.getCurrentTool().incrementSize(-1);
    }
}
