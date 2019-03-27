package com.frontanilla.necromance.gui;

public class RectangleButton extends RectangleImage {

    public RectangleButton(float x, float y, float w, float h) {
        super(x, y, w, h);
    }

    public boolean contains(float x, float y) {
        return bounds.contains(x, y);
    }

}