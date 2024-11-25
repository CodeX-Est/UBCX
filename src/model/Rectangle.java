package model;

import sound.MidiSynth;

import java.awt.*;

public class Rectangle extends Shape{
    public Rectangle(Point topLeft, MidiSynth midiSynth) {
        super(topLeft, midiSynth);
    }

    public Rectangle(int x, int y, int w, int h) {
        super(x, y, w, h);
    }
}
