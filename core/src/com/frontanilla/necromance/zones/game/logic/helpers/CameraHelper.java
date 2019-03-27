package com.frontanilla.necromance.zones.game.logic.helpers;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Rectangle;
import com.frontanilla.necromance.zones.game.GameScreen;
import com.frontanilla.necromance.zones.game.stuff.GameStuff;

public class CameraHelper {

    private GameScreen gameScreen;
    private GameStuff gameStuff;

    public void initializeStructure(GameScreen gameScreen, GameStuff gameStuff) {
        this.gameScreen = gameScreen;
        this.gameStuff = gameStuff;
    }

    public void initState() {
        OrthographicCamera staticCamera = gameScreen.getStaticCamera();
        Rectangle playAreaBounds = gameStuff.getPlayArea().getBounds();
        float cameraX = playAreaBounds.x + playAreaBounds.width / 2f;
        float cameraY = playAreaBounds.y + staticCamera.viewportHeight / 2f;
        staticCamera.position.set(cameraX, cameraY, 0);
        staticCamera.update();
    }
}
