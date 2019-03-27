package com.frontanilla.necromance.zones.game.stuff;

import com.frontanilla.necromance.gui.RectangleButton;

public class PlayArea extends RectangleButton {

    private RectangleButton innerBounds;

    public PlayArea(float x, float y, float w, float h, float thickness) {
        super(x, y, w, h);
        innerBounds = new RectangleButton(x + thickness, y + thickness, w - 2 * thickness, h - 2 * thickness);
    }

    @Override
    public boolean contains(float x, float y) {
        return innerBounds.contains(x, y);
    }
}
