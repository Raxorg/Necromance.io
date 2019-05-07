package com.frontanilla.necromance.zones.menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.frontanilla.necromance.zones.foundations.ZoneRenderer;
import com.frontanilla.necromance.zones.menu.stuff.MenuStuff;

public class MenuRenderer extends ZoneRenderer {

    // Structure
    private MenuScreen menuScreen;
    private MenuStuff menuStuff;
    // Rendering
    private SpriteBatch spriteBatch;
    private ShapeRenderer shapeRenderer;

    public void initializeStructure(MenuScreen menuScreen,
                                    MenuStuff menuStuff) {
        this.menuScreen = menuScreen;
        this.menuStuff = menuStuff;
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
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        // Use the Camera
        spriteBatch.setProjectionMatrix(menuScreen.getStaticCamera().combined);
        shapeRenderer.setProjectionMatrix(menuScreen.getStaticCamera().combined);
        // Render Static Stuff
        spriteBatch.begin();
        menuStuff.getBackground().render(spriteBatch);
        menuStuff.getPlayButton().render(spriteBatch);
        menuStuff.getWheelMenu().render(spriteBatch);
        menuStuff.getFader().render(spriteBatch);
        spriteBatch.end();
        // Render Debug Static Stuff
        shapeRenderer.begin();
        menuStuff.getWheelMenu().renderDebug(shapeRenderer);
        shapeRenderer.end();
    }
}