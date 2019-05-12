package com.frontanilla.necromance.zones.game.stuff;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.frontanilla.necromance.gui.RectangleImage;

public class Map {

    // TODO: Temporary components
    private RectangleImage background;
    private PlayArea playArea;
    private SpawnPoint[] spawnPoints;

    public Map(TextureRegion playAreaRegion, TextureRegion backgroundRegion, TextureRegion spawnPointRegion) {
        background = new RectangleImage(0, 0, 5000, 5000);
        background.setTextureRegion(backgroundRegion);
        playArea = new PlayArea(1000, 1000, 1000, 1000, 25);
        playArea.setTextureRegion(playAreaRegion);
        spawnPoints = new SpawnPoint[2];
        spawnPoints[0] = new SpawnPoint(
                0, 0, 100, 100
        );
        spawnPoints[0].setTextureRegion(spawnPointRegion);
        spawnPoints[1] = new SpawnPoint(
                500, 0, 100, 100
        );
        spawnPoints[1].setTextureRegion(spawnPointRegion);
    }

    public void render(SpriteBatch spriteBatch) {
        background.render(spriteBatch);
        playArea.render(spriteBatch);
        for (int i = 0; i < spawnPoints.length; i++) {
            spawnPoints[i].render(spriteBatch);
        }
    }

    public PlayArea getPlayArea() {
        return playArea;
    }
}
