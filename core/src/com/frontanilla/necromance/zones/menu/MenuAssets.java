package com.frontanilla.necromance.zones.menu;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.frontanilla.necromance.zones.foundations.ZoneAssets;
import com.frontanilla.necromance.zones.game.GameAssets;

import static com.frontanilla.necromance.zones.menu.MenuConstants.*;

public class MenuAssets extends ZoneAssets {

    private BitmapFont timesSquare;
    private TextureRegion background, plank, pixel;
    private Music medieval;
    // Pass to Menu Connector
    private GameAssets gameAssets;

    public void initializeStructure() {
        gameAssets = new GameAssets();
    }

    @Override
    public void queueAssetLoading() {
        assetManager = new AssetManager();
        assetManager.load(TIMES_SQUARE_FILE, BitmapFont.class);
        assetManager.load(MENU_ATLAS_FILE, Texture.class);
        assetManager.load(MEDIEVAL_MUSIC_FILE, Music.class);
    }

    @Override
    public void instantiateAssets() {
        timesSquare = assetManager.get(TIMES_SQUARE_FILE, BitmapFont.class);
        Texture menuAtlas = assetManager.get(MENU_ATLAS_FILE, Texture.class);
        background = new TextureRegion(menuAtlas, 0, 0, 3000, 1500);
        plank = new TextureRegion(menuAtlas, 0, 1500, 400, 200);
        pixel = new TextureRegion(menuAtlas, 400, 1500, 1, 1);
        medieval = assetManager.get(MEDIEVAL_MUSIC_FILE, Music.class);
    }

    // Getters
    public BitmapFont getTimesSquare() {
        return timesSquare;
    }

    public TextureRegion getBackground() {
        return background;
    }

    public TextureRegion getPlank() {
        return plank;
    }

    public TextureRegion getPixel() {
        return pixel;
    }

    public Music getMedieval() {
        return medieval;
    }

    // Pass to Menu Connector
    public GameAssets getGameAssets() {
        return gameAssets;
    }
}