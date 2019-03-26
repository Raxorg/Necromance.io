package com.frontanilla.necromance.utils.helpers;

import com.badlogic.gdx.graphics.Color;

public class Transform {

    public static Color stringToColor(String colorString) {
        switch (colorString) {
            case "R":
                return Color.RED;
            case "G":
                return Color.GREEN;
            case "B":
                return Color.BLUE;
            case "C":
                return Color.CYAN;
            case "Y":
                return Color.YELLOW;
            case "M":
                return Color.MAGENTA;
            default:
                return Color.WHITE;
        }
    }
}
