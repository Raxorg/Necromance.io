package com.frontanilla.necromance.zones.splash;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.frontanilla.necromance.zones.foundations.ZoneRenderer;

public class SplashRenderer extends ZoneRenderer {

    // Structure
    private SplashScreen splashScreen;
    private SplashStuff splashStuff;
    // Rendering
    private SpriteBatch spriteBatch;

    public void initializeStructure(SplashScreen splashScreen, SplashStuff splashStuff) {
        this.splashScreen = splashScreen;
        this.splashStuff = splashStuff;
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
        spriteBatch.setProjectionMatrix(splashScreen.getStaticCamera().combined);
        // Render Stuff
        spriteBatch.begin();
        splashStuff.getMessageText().render(spriteBatch);
        spriteBatch.end();
    }
}
