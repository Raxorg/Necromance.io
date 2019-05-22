package com.frontanilla.necromance.zones.game.stuff;

import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.frontanilla.necromance.zones.foundations.ZoneStuff;
import com.frontanilla.necromance.zones.game.GameAssets;
import com.frontanilla.necromance.zones.shared.SharedStuff;

public class GameStuff extends ZoneStuff {

    // Structure
    private GameAssets gameAssets;
    // Stuff
    private Map map;
    private Texture texture; // TODO TEST
    private NameBox messageBox;

    public GameStuff(SharedStuff sharedStuff) {
        super(sharedStuff);
    }

    public void initializeStructure(GameAssets gameAssets) {
        this.gameAssets = gameAssets;
    }

    @Override
    public void initStuff() {
        map = new Map(gameAssets.getPlayArea(), gameAssets.getHuman(), gameAssets.getSpawnPoint());
        messageBox = new NameBox(gameAssets.getFrozenNinePatch(), gameAssets.getTimesSquare());
        messageBox.setPosition(1000, 1000);
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

    public NameBox getMessageBox() {
        return messageBox;
    }
}