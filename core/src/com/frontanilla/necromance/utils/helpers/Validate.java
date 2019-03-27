package com.frontanilla.necromance.utils.helpers;

public class Validate {

    public static boolean colorString(String colorString) {
        switch (colorString) {
            case "R":
            case "G":
            case "B":
            case "C":
            case "Y":
            case "M":
                return true;
            default:
                return false;
        }
    }
}
