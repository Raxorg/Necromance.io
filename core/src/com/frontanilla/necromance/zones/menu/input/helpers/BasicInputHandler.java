package com.frontanilla.necromance.zones.menu.input.helpers;

import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.math.Vector3;
import com.frontanilla.necromance.zones.menu.MenuScreen;
import com.frontanilla.necromance.zones.menu.input.MenuInput;
import com.frontanilla.necromance.zones.menu.logic.MenuLogic;

public class BasicInputHandler extends InputAdapter {

    // Structure
    private MenuInput menuInput;
    private MenuLogic menuLogic;
    private MenuScreen menuScreen;
    // Input
    private Vector3 unprojected;

    public void initializeStructure(
            MenuInput menuInput,
            MenuLogic menuLogic,
            MenuScreen menuScreen) {
        this.menuInput = menuInput;
        this.menuLogic = menuLogic;
        this.menuScreen = menuScreen;
    }

    public void initConfig() {
        unprojected = new Vector3();
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        if (!menuInput.isEnabled() || pointer != 0) {
            return false;
        }
        unprojected = menuScreen.getCamera().unproject(new Vector3(screenX, screenY, 0));
        menuLogic.getProcessedInputHandler().touchDown(unprojected.x, unprojected.y);
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        if (!menuInput.isEnabled() || pointer != 0) {
            return false;
        }
        unprojected = menuScreen.getCamera().unproject(new Vector3(screenX, screenY, 0));
        menuLogic.getButtonHandler().touchUp(unprojected.x, unprojected.y);
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        if (!menuInput.isEnabled() || pointer != 0) {
            return false;
        }
        unprojected = menuScreen.getCamera().unproject(new Vector3(screenX, screenY, 0));
        menuLogic.getWheelMenuHandler().touchDragged(unprojected.x, unprojected.y);
        return false;
    }
}