package com.frontanilla.necromance.utils.helpers;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.MathUtils;

public class Random {

    public static Color color(Color avoidedColor) {
        int random = MathUtils.random(5);
        Color randomColor = Color.WHITE;
        switch (random) {
            case 0:
                randomColor = Color.RED;
                break;
            case 1:
                randomColor = Color.BLUE;
                break;
            case 2:
                randomColor = Color.GREEN;
                break;
            case 3:
                randomColor = Color.YELLOW;
                break;
            case 4:
                randomColor = Color.ORANGE;
                break;
            case 5:
                randomColor = Color.PURPLE;
        }
        return sameColor(randomColor, avoidedColor) ? color(avoidedColor) : randomColor;
    }

    private static boolean sameColor(Color a, Color b) {
        boolean same = false;
        if (a.r == b.r && a.g == b.g && a.b == b.b && a.a == b.a) {
            same = true;
        }
        return same;
    }
}