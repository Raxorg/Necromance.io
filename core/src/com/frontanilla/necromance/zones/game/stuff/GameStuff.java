package com.frontanilla.necromance.zones.game.stuff;

import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.frontanilla.necromance.database.representation.Human;
import com.frontanilla.necromance.zones.foundations.ZoneStuff;
import com.frontanilla.necromance.zones.game.GameAssets;
import com.frontanilla.necromance.zones.shared.SharedStuff;

public class GameStuff extends ZoneStuff {

    // Structure
    private GameAssets gameAssets;
    // Stuff
    private Map map;
    private Texture texture; // TODO TEST

    public GameStuff(SharedStuff sharedStuff) {
        super(sharedStuff);
    }

    public void initializeStructure(GameAssets gameAssets) {
        this.gameAssets = gameAssets;
    }

    @Override
    public void initStuff() {
        map = new Map(gameAssets.getPlayArea(), gameAssets.getHuman(), gameAssets.getSpawnPoint());
    }

    // Getters
    public Map getMap() {
        return map;
    }

    // TODO TEST
    public Texture getTexture() {
        return texture;
    }

    public void assignTexture(Pixmap pixmap) {
        texture = new Texture(pixmap);
        //pixmap.dispose();
    }
}
