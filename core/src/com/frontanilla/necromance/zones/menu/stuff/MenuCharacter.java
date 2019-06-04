package com.frontanilla.necromance.zones.menu.stuff;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.frontanilla.necromance.utils.structs.AdvancedRectangle;

public class MenuCharacter {

    private AdvancedRectangle bounds;
    private TextureRegion textureRegion;

    public MenuCharacter(float x, float y, float w, float h) {
        bounds = new AdvancedRectangle(x, y, w, h);
    }

    public void render(SpriteBatch spriteBatch) {
        spriteBatch.setColor(Color.WHITE);
        spriteBatch.draw(
                textureRegion,
                bounds.x, bounds.y,
                bounds.width, bounds.height);
    }

    public void renderDebug(ShapeRenderer shapeRenderer) {
        shapeRenderer.set(ShapeRenderer.ShapeType.Line);
        shapeRenderer.setColor(Color.RED);
        shapeRenderer.rect(bounds.x, bounds.y, bounds.width, bounds.height);
        shapeRenderer.set(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(Color.BLUE);
        shapeRenderer.circle(bounds.getLeft().x, bounds.getLeft().y, 5);
        shapeRenderer.circle(bounds.getRight().x, bounds.getLeft().y, 5);
    }

    public boolean contains(float x, float y) {
        return bounds.contains(x, y);
    }

    // Getters & Setters
    public AdvancedRectangle getBounds() {
        return bounds;
    }

    public void setTextureRegion(TextureRegion textureRegion) {
        this.textureRegion = textureRegion;
    }
}