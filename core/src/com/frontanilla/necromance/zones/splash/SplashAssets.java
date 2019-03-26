package com.frontanilla.necromance.zones.splash;

import com.frontanilla.necromance.zones.foundations.ZoneAssets;
import com.frontanilla.necromance.zones.game.GameAssets;

public class SplashAssets extends ZoneAssets {

    private GameAssets gameAssets;

    public void initializeStructure() {
        gameAssets = new GameAssets();
    }

    @Override
    public void queueAssetLoading() {

    }

    @Override
    public void instantiateAssets() {

    }

    public GameAssets getGameAssets() {
        return gameAssets;
    }
}
