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
    private DelayedRemovalArray<Human> players;
    private PlayArea playArea;
    private Texture texture; // TODO TEST

    public GameStuff(SharedStuff sharedStuff) {
        super(sharedStuff);
    }

    public void initializeStructure(GameAssets gameAssets) {
        this.gameAssets = gameAssets;
    }

    @Override
    public void initStuff() {
        players = new DelayedRemovalArray<>();
        playArea = new PlayArea(1000, 1000, 1000, 1000, 25);
        playArea.setTextureRegion(gameAssets.getPlayArea());
    }

    // Getters
    public DelayedRemovalArray<Human> getHumanPlayers() {
        return players;
    }

    public PlayArea getPlayArea() {
        return playArea;
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
