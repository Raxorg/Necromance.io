package com.frontanilla.necromance.zones.game;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.frontanilla.necromance.zones.foundations.ZoneAssets;

import static com.frontanilla.necromance.zones.game.GameConstants.GAME_ATLAS_FILE;
import static com.frontanilla.necromance.zones.game.GameConstants.TIMES_SQUARE_FILE;

public class GameAssets extends ZoneAssets {

    private BitmapFont timesSquare;
    private TextureRegion human;

    @Override
    public void queueAssetLoading() {
        assetManager = new AssetManager();
        assetManager.load(TIMES_SQUARE_FILE, BitmapFont.class);
        assetManager.load(GAME_ATLAS_FILE, Texture.class);
    }

    @Override
    public void instantiateAssets() {
        timesSquare = assetManager.get(TIMES_SQUARE_FILE, BitmapFont.class);
        Texture gameAtlas = assetManager.get(GAME_ATLAS_FILE, Texture.class);
        human = new TextureRegion(gameAtlas, 0, 0, 200, 200);
    }

    public BitmapFont getTimesSquare() {
        return timesSquare;
    }

    public TextureRegion getHuman() {
        return human;
    }
}
