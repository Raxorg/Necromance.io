package com.frontanilla.necromance.zones.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.frontanilla.necromance.zones.foundations.ZoneRenderer;

public class GameRenderer extends ZoneRenderer {

    // Structure
    private GameScreen gameScreen;
    private GameStuff gameStuff;
    // Rendering
    private SpriteBatch spriteBatch;

    public void initializeStructure(GameScreen gameScreen, GameStuff gameStuff) {
        this.gameScreen = gameScreen;
        this.gameStuff = gameStuff;
    }

    @Override
    public void initRenderers() {
        spriteBatch = new SpriteBatch();
    }

    @Override
    public void render() {
        // Clear Previous Frame
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        // Use the Camera
        spriteBatch.setProjectionMatrix(gameScreen.getStaticCamera().combined);
        // Render Stuff
        spriteBatch.begin();
        for (int i = 0; i < gameStuff.getHumanPlayers().size; i++) {
            gameStuff.getHumanPlayers().get(i).render(spriteBatch);
        }
        spriteBatch.end();
    }
}
