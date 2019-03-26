package com.frontanilla.necromance.utils.helpers;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.math.Vector2;

public class TextUtils {

    public static Vector2 getTextSize(String text, BitmapFont font) {
        Vector2 textSize = new Vector2();
        GlyphLayout layout = new GlyphLayout(font, text);
        textSize.x = layout.width;
        textSize.y = layout.height;
        return textSize;
    }

    public static float getTextWidth(String text, BitmapFont font) {
        return getTextSize(text, font).x;
    }

    public static float getTextHeight(String text, BitmapFont font) {
        return getTextSize(text, font).y;
    }
}
