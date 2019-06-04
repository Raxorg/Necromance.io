package com.frontanilla.necromance.zones.menu;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.frontanilla.necromance.zones.foundations.ZoneConnector;
import com.frontanilla.necromance.zones.foundations.ZoneScreen;

import static com.frontanilla.necromance.zones.menu.MenuConstants.CAMERA_HEIGHT;
import static com.frontanilla.necromance.zones.menu.MenuConstants.CAMERA_WIDTH;

public class MenuScreen extends ZoneScreen {

    private OrthographicCamera camera;

    public MenuScreen(ZoneConnector connector) {
        super(connector);
    }

    @Override
    public void initCameras() {
        camera = new OrthographicCamera();
        camera.setToOrtho(
                false,
                CAMERA_WIDTH,
                CAMERA_HEIGHT
        );
    }

    public OrthographicCamera getCamera() {
        return camera;
    }
}