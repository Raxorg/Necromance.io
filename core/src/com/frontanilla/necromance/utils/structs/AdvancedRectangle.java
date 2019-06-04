package com.frontanilla.necromance.utils.structs;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class AdvancedRectangle extends Rectangle {

    public AdvancedRectangle(float x, float y, float width, float height) {
        super(x, y, width, height);
    }

    public Vector2 getLeft() {
        Vector2 left = new Vector2();
        left.x = x;
        left.y = y + height / 2f;
        return left;
    }

    public Vector2 getRight() {
        Vector2 right = new Vector2();
        right.x = x + width;
        right.y = y + height / 2f;
        return right;
    }
}