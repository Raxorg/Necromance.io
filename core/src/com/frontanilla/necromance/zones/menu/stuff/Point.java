package com.frontanilla.necromance.zones.menu.stuff;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;

public class Point {

    private Vector2 position;

    public Point(float x, float y) {
        position = new Vector2(x, y);
    }

    public void renderDebug(ShapeRenderer shapeRenderer) {
        shapeRenderer.set(ShapeRenderer.ShapeType.Filled);
        shapeRenderer.setColor(Color.BLUE);
        shapeRenderer.circle(position.x, position.y, 5);
    }
}