package com.frontanilla.necromance.zones.menu.stuff;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.MathUtils;
import com.frontanilla.necromance.gui.RectangleButton;

public class WheelMenu {

    // Components
    private Circle bounds;
    private RectangleButton[] planks;
    private TextureRegion plankRegion;
    // Logic
    private float rotation;

    public WheelMenu(float x, float y, float r, TextureRegion plankRegion) {
        bounds = new Circle(x, y, r);
        planks = new RectangleButton[10];
        for (int i = 0; i < planks.length; i++) {
            float angle = (360f / 10f) * i * MathUtils.degreesToRadians + rotation;
            float plankX = bounds.x + bounds.radius * MathUtils.cos(angle);
            float plankY = bounds.y + bounds.radius * MathUtils.sin(angle);
            planks[i] = new RectangleButton(plankX, plankY, 100, 50);
            planks[i].setTextureRegion(plankRegion);
        }
        this.plankRegion = plankRegion;
        rotation = 0;
    }

    public void update(float delta) {
        rotation += delta;
        for (int i = 0; i < planks.length; i++) {
            float angle = (360f / 10f) * i * MathUtils.degreesToRadians + rotation;
            float plankX = bounds.x + bounds.radius * MathUtils.cos(angle);
            float plankY = bounds.y + bounds.radius * MathUtils.sin(angle);
            planks[i].getBounds().x = plankX;
            planks[i].getBounds().y = plankY;
        }
    }

    public void render(SpriteBatch spriteBatch) {
        for (int i = 0; i < planks.length; i++) {
            planks[i].render(spriteBatch);
        }
    }

    public void renderDebug(ShapeRenderer shapeRenderer) {
        // The Circle
        shapeRenderer.setColor(Color.RED);
        shapeRenderer.circle(bounds.x, bounds.y, bounds.radius);
        // The Points Where Planks are Attached
        shapeRenderer.set(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(Color.BLUE);
        for (int i = 0; i < 10; i++) {
            float angle = (360f / 10f) * i * MathUtils.degreesToRadians + rotation;
            float x = bounds.x + bounds.radius * MathUtils.cos(angle);
            float y = bounds.y + bounds.radius * MathUtils.sin(angle);
            shapeRenderer.circle(x, y, 5);
        }
    }

    public void setPlankTexture(TextureRegion plankRegion) {
        this.plankRegion = plankRegion;
    }
}