package com.frontanilla.necromance.zones.game;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.frontanilla.necromance.zones.foundations.ZoneAssets;

import static com.frontanilla.necromance.zones.game.GameConstants.*;

public class GameAssets extends ZoneAssets {

    private BitmapFont timesSquare;
    private TextureRegion human;
    private TextureRegion playArea, frozenNinePatch, spawnPoint;
    private TextureRegion necromancerDoctor, necromancerHood;

    @Override
    public void queueAssetLoading() {
        assetManager = new AssetManager();
        assetManager.load(TIMES_SQUARE_FILE, BitmapFont.class);
        assetManager.load(GAME_ATLAS_FILE, Texture.class);
        assetManager.load(CHARACTER_ATLAS_FILE, Texture.class);
    }

    @Override
    public void instantiateAssets() {
        timesSquare = assetManager.get(TIMES_SQUARE_FILE, BitmapFont.class);
        Texture gameAtlas = assetManager.get(GAME_ATLAS_FILE, Texture.class);
        gameAtlas.setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest);
        human = new TextureRegion(gameAtlas, 1024, 500, 200, 200);
        playArea = new TextureRegion(gameAtlas, 0, 0, 1024, 1024);
        frozenNinePatch = new TextureRegion(gameAtlas, 1024, 700, 64, 64);
        spawnPoint = new TextureRegion(gameAtlas, 1024, 0, 500, 500);
        Texture characterAtlas = assetManager.get(CHARACTER_ATLAS_FILE, Texture.class);
        necromancerDoctor = new TextureRegion(characterAtlas, 0, 0, 1369, 1748);
        necromancerHood = new TextureRegion(characterAtlas, 1369, 0, 921, 1532);
    }

    public BitmapFont getTimesSquare() {
        return timesSquare;
    }

    public TextureRegion getHuman() {
        return human;
    }

    public TextureRegion getPlayArea() {
        return playArea;
    }

    public TextureRegion getFrozenNinePatch() {
        return frozenNinePatch;
    }

    public TextureRegion getSpawnPoint() {
        return spawnPoint;
    }

    public TextureRegion getNecromancerDoctor() {
        return necromancerDoctor;
    }

    public TextureRegion getNecromancerHood() {
        return necromancerHood;
    }
}