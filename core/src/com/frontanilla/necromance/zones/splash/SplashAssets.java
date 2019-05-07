package com.frontanilla.necromance.zones.splash;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.frontanilla.necromance.zones.foundations.ZoneAssets;
import com.frontanilla.necromance.zones.menu.MenuAssets;

import static com.frontanilla.necromance.zones.splash.SplashConstants.SPLASH_ATLAS_FILE;
import static com.frontanilla.necromance.zones.splash.SplashConstants.TIMES_SQUARE_FILE;

public class SplashAssets extends ZoneAssets {

    private BitmapFont timesSquare;
    private TextureRegion splashLogo, circle, pixel;
    // Pass to Menu Connector
    private MenuAssets menuAssets;

    public void initializeStructure() {
        menuAssets = new MenuAssets();
    }

    @Override
    public void queueAssetLoading() {
        assetManager = new AssetManager();
        assetManager.load(TIMES_SQUARE_FILE, BitmapFont.class);
        assetManager.load(SPLASH_ATLAS_FILE, Texture.class);
        assetManager.finishLoading(); // Special Case
        instantiateAssets();
    }

    @Override
    public void instantiateAssets() {
        timesSquare = assetManager.get(TIMES_SQUARE_FILE, BitmapFont.class);
        Texture splashAtlas = assetManager.get(SPLASH_ATLAS_FILE, Texture.class);
        splashLogo = new TextureRegion(splashAtlas, 0, 0, 800, 800);
        circle = new TextureRegion(splashAtlas, 800, 0, 800, 800);
        pixel = new TextureRegion(splashAtlas, 1600, 0, 1, 1);
    }

    public BitmapFont getTimesSquare() {
        return timesSquare;
    }

    public TextureRegion getSplashLogo() {
        return splashLogo;
    }

    public TextureRegion getCircle() {
        return circle;
    }

    public TextureRegion getPixel() {
        return pixel;
    }

    // Pass to Menu Connector
    public MenuAssets getMenuAssets() {
        return menuAssets;
    }
}
