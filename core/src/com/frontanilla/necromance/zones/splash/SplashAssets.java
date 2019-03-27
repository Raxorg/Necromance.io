package com.frontanilla.necromance.zones.splash;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.frontanilla.necromance.zones.foundations.ZoneAssets;
import com.frontanilla.necromance.zones.game.GameAssets;

import static com.frontanilla.necromance.zones.splash.SplashConstants.TIMES_SQUARE_FILE;

public class SplashAssets extends ZoneAssets {

    private BitmapFont timesSquare;
    // Pass to Game Connector
    private GameAssets gameAssets;

    public void initializeStructure() {
        gameAssets = new GameAssets();
    }

    @Override
    public void queueAssetLoading() {
        assetManager = new AssetManager();
        assetManager.load(TIMES_SQUARE_FILE, BitmapFont.class);
        assetManager.finishLoading(); // Special Case
        instantiateAssets();
    }

    @Override
    public void instantiateAssets() {
        timesSquare = assetManager.get(TIMES_SQUARE_FILE, BitmapFont.class);
    }

    public BitmapFont getTimesSquare() {
        return timesSquare;
    }

    // Pass to Game Connector
    public GameAssets getGameAssets() {
        return gameAssets;
    }
}
