package com.frontanilla.necromance.gui;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Circle;

public class CircleImage extends Image {

    protected Circle bounds;

    public CircleImage(float x, float y, float r) {
        bounds = new Circle(x, y, r);
        color = Color.WHITE;
    }

    public void render(SpriteBatch spriteBatch) {
        spriteBatch.setColor(color);
        spriteBatch.draw(textureRegion, bounds.x - bounds.radius, bounds.y - bounds.radius, bounds.radius * 2f, bounds.radius * 2f);
    }

    // Getters & Setters
    public Circle getBounds() {
        return bounds;
    }

    public void setTextureRegion(TextureRegion textureRegion) {
        this.textureRegion = textureRegion;
    }
}