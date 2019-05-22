package com.frontanilla.necromance.utils.helpers;

import com.badlogic.gdx.graphics.Color;

public class ColorUtils {

    public static Color colorWithAlpha(Color color, float alpha) {
        return new Color(color.r, color.g, color.b, alpha);
    }
}