package com.frontanilla.necromance.zones.splash;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.frontanilla.necromance.zones.foundations.ZoneConnector;
import com.frontanilla.necromance.zones.foundations.ZoneScreen;

import static com.frontanilla.necromance.zones.splash.SplashConstants.CAMERA_HEIGHT;

public class SplashScreen extends ZoneScreen {

    private OrthographicCamera staticCamera;

    public SplashScreen(ZoneConnector connector) {
        super(connector);
    }

    @Override
    public void initCameras() {
        float ratio = (float) Gdx.graphics.getWidth() / (float) Gdx.graphics.getHeight();
        staticCamera = new OrthographicCamera();
        staticCamera.setToOrtho(
                false,
                CAMERA_HEIGHT * ratio,
                CAMERA_HEIGHT
        );
    }

    public OrthographicCamera getStaticCamera() {
        return staticCamera;
    }
}
