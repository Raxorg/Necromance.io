package com.frontanilla.necromance.zones.menu.input.helpers;

import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.math.Vector3;
import com.frontanilla.necromance.zones.menu.MenuScreen;
import com.frontanilla.necromance.zones.menu.input.MenuInput;
import com.frontanilla.necromance.zones.menu.logic.MenuLogic;

public class AdvancedInputHandler extends GestureDetector.GestureAdapter {

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
    public boolean fling(float velocityX, float velocityY, int button) {
        if (menuInput.isEnabled()) {
            menuLogic.getWheelMenuHandler().fling(velocityY);
        }
        return false;
    }
}