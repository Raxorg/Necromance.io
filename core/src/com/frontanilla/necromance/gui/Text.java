package com.frontanilla.necromance.gui;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Align;
import com.frontanilla.necromance.utils.helpers.TextUtils;

import static com.frontanilla.necromance.utils.GlobalConstants.ALPHABET;

public class Text {

    protected Rectangle bounds;
    protected BitmapFont font;
    protected String text;
    protected Color color;

    public Text(float x, float y, float w, BitmapFont font) {
        bounds = new Rectangle(x, y, w, TextUtils.getTextHeight(ALPHABET, font));
        this.font = font;
    }

    public void render(SpriteBatch spriteBatch) {
        font.setColor(color);
        font.draw(spriteBatch, text, bounds.x, bounds.y + bounds.height / 2f, bounds.width, Align.center, true);
    }

    public void renderDebug(ShapeRenderer shapeRenderer) {
        // TODO
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
