package com.frontanilla.necromance.zones.menu.logic.helpers;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.frontanilla.necromance.zones.menu.MenuScreen;
import com.frontanilla.necromance.zones.menu.logic.MenuLogic;
import com.frontanilla.necromance.zones.menu.stuff.MenuStuff;

public class CharacterSelectionHandler {

    private MenuLogic menuLogic;
    private MenuScreen menuScreen;
    private MenuStuff menuStuff;
    // Logic
    private boolean zoomingIn, zoomingOut, zoomedIn;

    public void initializeStructure(
            MenuLogic menuLogic,
            MenuScreen menuScreen,
            MenuStuff menuStuff
    ) {
        this.menuLogic = menuLogic;
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
        // TODO: Calculate where to zoom, how to zoom etc, maybe use interpolation
        menuLogic.getCharacterMovementHandler().setMoving(false);
        zoomingIn = true;
    }

    private void zoomOut() {
        menuLogic.getCharacterMovementHandler().setMoving(true);
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