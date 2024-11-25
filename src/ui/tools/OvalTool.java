package ui.tools;

import model.Oval;
import model.Shape;
import ui.DrawingEditor;

import javax.swing.*;
import java.awt.event.MouseEvent;

public class OvalTool extends ShapeTool{
    private Shape shape;
    public OvalTool(DrawingEditor editor, JComponent parent) {
        super(editor, parent);
        shape = null;
    }

    @Override
    protected String getLabel() {
        return "Oval";
    }
    @Override
    public void mousePressedInDrawingArea(MouseEvent e) {
        makeShape(e);
        System.out.println(shape);
        shape.selectAndPlay();
        shape.setBounds(e.getPoint());
        editor.addToDrawing(shape);
    }
    //EFFECTS: Constructs and returns the new shape
    @Override
    public void makeShape(MouseEvent e) {

        shape = new Oval(e.getPoint(), editor.getMidiSynth());
    }
    // MODIFIES: this
    // EFFECTS:  unselects this shape, and sets it to null
    @Override
    public void mouseReleasedInDrawingArea(MouseEvent e) {
        shape.unselectAndStopPlaying();
        shape = null;
    }
    // MODIFIES: this
    // EFFECTS:  sets the bounds of thes shape to where the mouse is dragged to
    @Override
    public void mouseDraggedInDrawingArea(MouseEvent e) {
        shape.setBounds(e.getPoint());
    }
}
