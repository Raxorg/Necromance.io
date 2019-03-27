package com.frontanilla.necromance.gui;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;

public class RectangleImage {

    protected Rectangle bounds;
    protected TextureRegion textureRegion;
    protected Color color;

    public RectangleImage(float x, float y, float w, float h) {
        bounds = new Rectangle(x, y, w, h);
        color = Color.WHITE;
    }

    public void render(SpriteBatch spriteBatch) {
        spriteBatch.setColor(color);
        spriteBatch.draw(textureRegion, bounds.x, bounds.y, bounds.width, bounds.height);
    }

    // Getters & Setters
    public Rectangle getBounds() {
        return bounds;
    }

    public void setTextureRegion(TextureRegion textureRegion) {
        this.textureRegion = textureRegion;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
