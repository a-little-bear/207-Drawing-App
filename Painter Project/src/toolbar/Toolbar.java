package toolbar;

import use_case.ImageExportInputBoundary;
import use_case.InputBoundary;

import javax.swing.*;

import java.util.ArrayList;

public class Toolbar extends JPanel {
    public ArrayList<Button> buttons;
    private ButtonGroup toolButtons;
    private final InputBoundary interactor;
    private final ImageExportInputBoundary imageExportInteractor;

    public Toolbar(InputBoundary interactor, ImageExportInputBoundary imageExportInteractor) {
        this.buttons = new ArrayList<Button>();
        this.toolButtons = new ButtonGroup();
        this.interactor = interactor;
        this.imageExportInteractor = imageExportInteractor;

        addPaintToolButton();
        addEraserToolButton();
        addFillToolButton();

        addColourActionButton();
        addLatexOCRActionButton();
        addSaveActionButton();
    }

    public void addPaintToolButton() {
        PaintToolButton Ptb = new PaintToolButton(interactor);
        buttons.add(Ptb);
        toolButtons.add(Ptb);
    }

    public void addEraserToolButton() {
        EraserToolButton Etb = new EraserToolButton(interactor);
        buttons.add(Etb);
        toolButtons.add(Etb);
    }

    public void addFillToolButton() {
        FillToolButton Ftb = new FillToolButton(interactor);
        buttons.add(Ftb);
        toolButtons.add(Ftb);
    }

    public void addColourActionButton() {
        ColourActionButton Cab = new ColourActionButton(interactor);
        buttons.add(Cab);
    }

    public void addLatexOCRActionButton() {
        LatexOCRActionButton Lab = new LatexOCRActionButton(interactor);
        buttons.add(Lab);
    }

    public void addSaveActionButton() {
        SaveActionButton Sab = new SaveActionButton(interactor, imageExportInteractor);
        buttons.add(Sab);
    }
}
