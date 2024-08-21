package toolbar;

import interface_adapter.Controller;
import lombok.Getter;
import toolbar.button.*;
import toolbar.button.action_button.*;
import toolbar.button.tool_toggle_button.EraserToolToggleButton;
import toolbar.button.tool_toggle_button.FillToolToggleButton;
import toolbar.button.tool_toggle_button.PaintToolToggleButton;
import use_case.ImageExportInputBoundary;
import use_case.InputBoundary;
import use_case.InputData;
import interface_adapter.press_button.ButtonPressedFacade;
import interface_adapter.press_button.action_button.*;
import interface_adapter.press_button.tool_toggle_button.EraserButtonPressed;
import interface_adapter.press_button.tool_toggle_button.FillButtonPressed;
import interface_adapter.press_button.tool_toggle_button.PaintButtonPressed;

import javax.swing.*;
import java.util.ArrayList;

/**
 * The ToolbarFactory class is responsible for creating and assembling the toolbar
 * in the application. It initializes the toolbar with various tool and action buttons,
 * configuring each button with its associated functionality and interaction logic.
 */
public class ToolbarFactory {
    private final InputData inputData;
    private final InputBoundary interactor;
    private final ImageExportInputBoundary imageExportInteractor;
    private final ButtonPressedFacade buttonPressedFacade;
    private final ButtonGroup toolButtons;
    private final ArrayList<Pressable> buttons;
    @Getter private final Toolbar toolbar;

    /**
     * Constructs a ToolbarFactory with the specified controller, input data, interactor,
     * and image export interactor. The factory initializes the toolbar and adds the
     * necessary tool and action buttons.
     *
     * @param controller           The controller managing the application's logic.
     * @param inputData            The input data that stores the state of inputs.
     * @param interactor           The interactor responsible for handling user inputs.
     * @param imageExportInteractor The interactor responsible for exporting images.
     */
    public ToolbarFactory(Controller controller, InputData inputData, InputBoundary interactor, ImageExportInputBoundary imageExportInteractor) {
        this.inputData = inputData;
        this.interactor = interactor;
        this.imageExportInteractor = imageExportInteractor;
        buttonPressedFacade = new ButtonPressedFacade();
        toolButtons = new ButtonGroup();
        buttons = new ArrayList<>();

        toolbar = new Toolbar(buttons, toolButtons);

        addPaintToolButton();
        addEraserToolButton();
        addFillToolButton();
        addColourActionButton();
        addLatexOCRActionButton();
        addSaveActionButton();
        addExportCanvasActionButton();
        addImportCanvasActionButton();
    }

    /**
     * Adds the Paint Tool button to the toolbar and sets it as the selected tool by default.
     */
    public void addPaintToolButton() {
        PaintButtonPressed pbp = new PaintButtonPressed(interactor);
        PaintToolToggleButton ptb = new PaintToolToggleButton(pbp);
        buttons.add(ptb);
        toolButtons.add(ptb);
        ptb.setSelected(true);
        buttonPressedFacade.pressPaintButton(interactor.getInputData());
        toolbar.add(ptb);
    }

    /**
     * Adds the Eraser Tool button to the toolbar.
     */
    public void addEraserToolButton() {
        EraserButtonPressed ebp = new EraserButtonPressed(interactor);
        EraserToolToggleButton etb = new EraserToolToggleButton(ebp);
        buttons.add(etb);
        toolButtons.add(etb);
        toolbar.add(etb);
    }

    /**
     * Adds the Fill Tool button to the toolbar.
     */
    public void addFillToolButton() {
        FillButtonPressed fbp = new FillButtonPressed(interactor);
        FillToolToggleButton ftb = new FillToolToggleButton(fbp);
        buttons.add(ftb);
        toolButtons.add(ftb);
        toolbar.add(ftb);
    }

    /**
     * Adds the Color Picker action button to the toolbar.
     */
    public void addColourActionButton() {
        ColorButtonPressed cbp = new ColorButtonPressed(interactor);
        ColorActionButton cab = new ColorActionButton(cbp);
        buttons.add(cab);
        toolbar.add(cab);
    }

    /**
     * Adds the LaTeX OCR action button to the toolbar.
     */
    public void addLatexOCRActionButton() {
        LatexOCRButtonPressed lbp = new LatexOCRButtonPressed(interactor);
        LatexOCRActionButton Lab = new LatexOCRActionButton(lbp);
        buttons.add(Lab);
        toolbar.add(Lab);
    }

    /**
     * Adds the Save action button to the toolbar.
     */
    public void addSaveActionButton() {
        SaveButtonPressed sbp = new SaveButtonPressed(interactor, imageExportInteractor);
        SaveActionButton Sab = new SaveActionButton(sbp);
        buttons.add(Sab);
        toolbar.add(Sab);
    }

    /**
     * Adds the Export Canvas action button to the toolbar.
     */
    public void addExportCanvasActionButton() {
        ExportCanvasButtonPressed ecbp = new ExportCanvasButtonPressed(interactor);
        ExportCanvasActionButton ecab = new ExportCanvasActionButton(ecbp);
        buttons.add(ecab);
        toolbar.add(ecab);
    }

    /**
     * Adds the Import Canvas action button to the toolbar.
     */
    public void addImportCanvasActionButton() {
        ImportCanvasButtonPressed icbp = new ImportCanvasButtonPressed(interactor);
        ImportCanvasActionButton icab = new ImportCanvasActionButton(icbp);
        buttons.add(icab);
        toolbar.add(icab);
    }
}
