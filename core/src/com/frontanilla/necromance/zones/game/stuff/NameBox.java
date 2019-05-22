package com.frontanilla.necromance.zones.game.stuff;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Align;
import com.frontanilla.necromance.utils.helpers.TextUtils;

import static com.frontanilla.necromance.utils.GlobalConstants.ALPHABET;

public class NameBox {

    // Box
    private Rectangle bounds;
    private float margin;
    private TextureRegion topLeft, top, topRight, right, bottomRight, bottom, bottomLeft, left, center;
    private Color boxColor, fontColor;
    // Text
    private BitmapFont font;
    private String text;
    private float textHeight;

    public NameBox(TextureRegion ninePatch, BitmapFont font) {
        // Box
        textHeight = TextUtils.getTextHeight(ALPHABET, font);
        margin = textHeight * 0.3f;
        bounds = new Rectangle(0, 0, 0, textHeight + 3 * margin);
        topLeft = new TextureRegion(ninePatch, 0, 0, 12, 10);
        top = new TextureRegion(ninePatch, 12, 0, 42, 10);
        topRight = new TextureRegion(ninePatch, 54, 0, 10, 10);
        right = new TextureRegion(ninePatch, 54, 10, 10, 42);
        bottomRight = new TextureRegion(ninePatch, 54, 52, 10, 12);
        bottom = new TextureRegion(ninePatch, 12, 52, 42, 12);
        bottomLeft = new TextureRegion(ninePatch, 0, 52, 12, 12);
        left = new TextureRegion(ninePatch, 0, 10, 12, 42);
        center = new TextureRegion(ninePatch, 12, 10, 42, 42);
        boxColor = Color.WHITE;
        fontColor = Color.BLACK;
        // Text
        this.font = font;
        text = "";
    }

    public void render(SpriteBatch spriteBatch) {
        spriteBatch.setColor(boxColor);
        spriteBatch.draw(topLeft, bounds.x, bounds.y + bounds.height - margin, margin, margin);
        spriteBatch.draw(top, bounds.x + margin, bounds.y + bounds.height - margin, bounds.width - 2 * margin, margin);
        spriteBatch.draw(topRight, bounds.x + bounds.width - margin, bounds.y + bounds.height - margin, margin, margin);
        spriteBatch.draw(right, bounds.x + bounds.width - margin, bounds.y + margin, margin, bounds.height - 2 * margin);
        spriteBatch.draw(bottomRight, bounds.x + bounds.width - margin, bounds.y, margin, margin);
        spriteBatch.draw(bottom, bounds.x + margin, bounds.y, bounds.width - 2 * margin, margin);
        spriteBatch.draw(bottomLeft, bounds.x, bounds.y, margin, margin);
        spriteBatch.draw(left, bounds.x, bounds.y + margin, margin, bounds.height - 2 * margin);
        spriteBatch.draw(center, bounds.x + margin, bounds.y + margin, bounds.width - 2 * margin, bounds.height - 2 * margin);
        font.setColor(fontColor);
        font.draw(
                spriteBatch,
                text,
                bounds.x + margin,
                bounds.y + bounds.height / 2f + textHeight / 2f,
                bounds.width - 2 * margin,
                Align.center,
                true);
    }

    // Getters & Setters
    public float getX() {
        return bounds.x;
    }

    public float getY() {
        return bounds.y;
    }

    public void setPosition(float x, float y) {
        bounds.x = x;
        bounds.y = y;
    }

    public float getWidth() {
        return bounds.width;
    }

    public Color getBoxColor() {
        return boxColor;
    }

    public void setBoxColor(Color boxColor) {
        this.boxColor = boxColor;
    }

    public Color getFontColor() {
        return fontColor;
    }

    public void setFontColor(Color fontColor) {
        this.fontColor = fontColor;
    }

    public void setText(String text) {
        this.text = text;
        bounds.width = TextUtils.getTextWidth(text, font) + 3 * margin;
    }

    public float getTextHeight() {
        return textHeight;
    }
}
