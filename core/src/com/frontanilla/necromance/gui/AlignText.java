package com.frontanilla.necromance.gui;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Align;

public class AlignText extends Text {

    private boolean yUp;

    public AlignText(float x, float y, float w, BitmapFont font, boolean yUp) {
        super(x, y, w, font);
        this.yUp = yUp;
    }

    @Override
    public void render(SpriteBatch spriteBatch) {
        font.setColor(color);
        font.draw(spriteBatch, text, bounds.x, bounds.y + (yUp ? 0 : -bounds.height), bounds.width, Align.center, true);
    }
}
