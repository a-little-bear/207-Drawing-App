package toolbar;

import interface_adapter.Controller;
import lombok.Getter;
import toolbar.button.*;
import toolbar.button.action_button.ColorActionButton;
import toolbar.button.tool_toggle_button.EraserToolToggleButton;
import toolbar.button.tool_toggle_button.FillToolToggleButton;
import toolbar.button.tool_toggle_button.PaintToolToggleButton;
import toolbar.button.action_button.LatexOCRActionButton;
import toolbar.button.action_button.SaveActionButton;
import use_case.ImageExportInputBoundary;
import use_case.InputBoundary;
import use_case.InputData;
import use_case.press_button.ButtonPressedFacade;
import use_case.press_button.action_button.ColorButtonPressed;
import use_case.press_button.action_button.LatexOCRButtonPressed;
import use_case.press_button.action_button.SaveButtonPressed;
import use_case.press_button.tool_toggle_button.EraserButtonPressed;
import use_case.press_button.tool_toggle_button.FillButtonPressed;
import use_case.press_button.tool_toggle_button.PaintButtonPressed;

import javax.swing.*;
import java.util.ArrayList;

public class ToolbarFactory {
    private final InputData inputData;
    private final InputBoundary interactor;
    private final ImageExportInputBoundary imageExportInteractor;
    private final ButtonPressedFacade buttonPressedFacade;
    private final ButtonGroup toolButtons;
    private final ArrayList<Pressable> buttons;
    @Getter private final Toolbar toolbar;

    public ToolbarFactory(Controller controller, InputData inputData, InputBoundary interactor, ImageExportInputBoundary imageExportInteractor){
        this.inputData = inputData;
        this.interactor = interactor;
        this.imageExportInteractor = imageExportInteractor;
        buttonPressedFacade = new ButtonPressedFacade();
        toolButtons = new ButtonGroup();
        buttons = new ArrayList<Pressable>();

        toolbar = new Toolbar(buttons, toolButtons);

        addPaintToolButton();
        addEraserToolButton();
        addFillToolButton();
        addColourActionButton();
        addLatexOCRActionButton();
        addSaveActionButton();
    }


    public void addPaintToolButton() {
        PaintButtonPressed pbp = new PaintButtonPressed(interactor);
        PaintToolToggleButton ptb = new PaintToolToggleButton(pbp);
        buttons.add(ptb);
        toolButtons.add(ptb);
        ptb.setSelected(true);
        buttonPressedFacade.pressPaintButton(interactor.getInputData());
        toolbar.add(ptb);
    }

    public void addEraserToolButton() {
        EraserButtonPressed ebp = new EraserButtonPressed(interactor);
        EraserToolToggleButton etb = new EraserToolToggleButton(ebp);
        buttons.add(etb);
        toolButtons.add(etb);
        toolbar.add(etb);
    }

    public void addFillToolButton() {
        FillButtonPressed fbp = new FillButtonPressed(interactor);
        FillToolToggleButton ftb = new FillToolToggleButton(fbp);
        buttons.add(ftb);
        toolButtons.add(ftb);
        toolbar.add(ftb);
    }

    public void addColourActionButton() {
        ColorButtonPressed cbp = new ColorButtonPressed(interactor);
        ColorActionButton cab = new ColorActionButton(cbp);
        buttons.add(cab);
        toolbar.add(cab);
    }

    public void addLatexOCRActionButton() {
        LatexOCRButtonPressed lbp = new LatexOCRButtonPressed(interactor);
        LatexOCRActionButton Lab = new LatexOCRActionButton(lbp);
        buttons.add(Lab);
        toolbar.add(Lab);
    }

    public void addSaveActionButton() {
        SaveButtonPressed sbp = new SaveButtonPressed(interactor, imageExportInteractor);
        SaveActionButton Sab = new SaveActionButton(sbp);
        buttons.add(Sab);
        toolbar.add(Sab);
    }
}
