package com.frontanilla.necromance.zones.menu.logic.helpers;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.frontanilla.necromance.zones.menu.MenuScreen;
import com.frontanilla.necromance.zones.menu.stuff.MenuStuff;

public class CharacterSelectionHandler {

    private MenuScreen menuScreen;
    private MenuStuff menuStuff;
    // Logic
    private boolean zoomingIn, zoomingOut, zoomedIn;

    public void initializeStructure(
            MenuScreen menuScreen,
            MenuStuff menuStuff
    ) {
        this.menuScreen = menuScreen;
        this.menuStuff = menuStuff;
    }

    public void initState() {
        zoomingIn = false;
        zoomingOut = false;
        zoomedIn = false;
    }


    public void update(float delta) {
        OrthographicCamera camera = menuScreen.getCamera();
        if (zoomingIn) {
            camera.zoom -= delta;
            if (camera.zoom <= 0.5f) {
                camera.zoom = 0.5f;
                zoomingIn = false;
                zoomedIn = true;
            }
        }
        if (zoomingOut) {
            camera.zoom += delta;
            if (camera.zoom >= 1f) {
                camera.zoom = 1f;
                zoomingOut = false;
                zoomedIn = false;
            }
        }
        camera.update();
    }

    private void zoomIn() {
        // TODO: Calculate where to zoom in
        zoomingIn = true;
    }

    private void zoomOut() {
        zoomingOut = true;
    }

    public void touchDownOnCharacter() {
        if (zoomingIn || zoomingOut) {
            return;
        }
        if (zoomedIn) {
            zoomOut();
        } else {
            zoomIn();
        }
    }
}