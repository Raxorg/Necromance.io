package com.frontanilla.necromance.utils.helpers;

import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class SizeUtils {

    public static float getHeightToWidthRatio(TextureRegion textureRegion) {
        return (float) textureRegion.getRegionHeight() / (float) textureRegion.getRegionWidth();
    }
}