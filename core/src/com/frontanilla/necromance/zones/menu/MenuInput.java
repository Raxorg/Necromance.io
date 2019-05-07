package com.frontanilla.necromance.zones.menu;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector3;
import com.frontanilla.necromance.zones.foundations.ZoneInput;
import com.frontanilla.necromance.zones.menu.logic.MenuLogic;

public class MenuInput extends ZoneInput {

    private MenuLogic menuLogic;
    private MenuScreen menuScreen;
    // Input Handling
    private Vector3 unprojected;

    public void initializeStructure(
            MenuLogic menuLogic,
            MenuScreen menuScreen) {
        this.menuLogic = menuLogic;
        this.menuScreen = menuScreen;
    }

    @Override
    public void initConfig() {
        unprojected = new Vector3();
        Gdx.input.setInputProcessor(this);
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        unprojected = menuScreen.getStaticCamera().unproject(new Vector3(screenX, screenY, 0));
        menuLogic.getButtonHandler().touchUp(unprojected.x, unprojected.y);
        return true;
    }
}