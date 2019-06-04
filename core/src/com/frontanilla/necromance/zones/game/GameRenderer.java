package com.frontanilla.necromance.zones.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.frontanilla.necromance.zones.foundations.ZoneRenderer;
import com.frontanilla.necromance.zones.game.stuff.GameStuff;

public class GameRenderer extends ZoneRenderer {

    // Structure
    private GameNetworked gameNetworked;
    private GameScreen gameScreen;
    private GameStuff gameStuff;
    // Rendering
    private SpriteBatch spriteBatch;
    private ShapeRenderer shapeRenderer;

    public void initializeStructure(
            GameNetworked gameNetworked,
            GameScreen gameScreen,
            GameStuff gameStuff) {
        this.gameNetworked = gameNetworked;
        this.gameScreen = gameScreen;
        this.gameStuff = gameStuff;
    }

    @Override
    public void initRenderers() {
        spriteBatch = new SpriteBatch();
        shapeRenderer = new ShapeRenderer();
        shapeRenderer.setAutoShapeType(true);
    }

    @Override
    public void render() {
        // Clear Previous Frame
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        renderStuff();
        renderDebugStuff();
    }

    private void renderStuff() {
        // Use the Camera
        spriteBatch.setProjectionMatrix(gameScreen.getStaticCamera().combined);
        // Render Stuff
        spriteBatch.begin();
        gameStuff.getMap().render(spriteBatch);
        for (int i = 0; i < gameNetworked.getHumanPlayers().size; i++) {
            gameNetworked.getHumanPlayers().get(i).render(spriteBatch);
        }
        // TODO: TEST
        if (gameStuff.getTexture() != null) {
            spriteBatch.setColor(Color.WHITE);
            spriteBatch.draw(gameStuff.getTexture(), 1500, 1500);
        }

        gameStuff.getMessageBox().render(spriteBatch);
        spriteBatch.end();
    }

    private void renderDebugStuff() {
        // Use the camera
        shapeRenderer.setProjectionMatrix(gameScreen.getStaticCamera().combined);
        shapeRenderer.begin();
        // TODO
        shapeRenderer.end();
    }
}