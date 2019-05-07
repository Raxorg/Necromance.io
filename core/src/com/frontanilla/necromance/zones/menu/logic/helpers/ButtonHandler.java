package com.frontanilla.necromance.zones.menu.logic.helpers;

import com.frontanilla.necromance.zones.menu.logic.MenuLogic;
import com.frontanilla.necromance.zones.menu.stuff.MenuStuff;

public class ButtonHandler {

    // Structure
    private MenuLogic menuLogic;
    private MenuStuff menuStuff;

    public void initializeStructure(
            MenuLogic menuLogic,
            MenuStuff menuStuff) {
        this.menuLogic = menuLogic;
        this.menuStuff = menuStuff;
    }

    public void initState() {

    }

    public void touchUp(float x, float y) {
        if (menuStuff.getPlayButton().contains(x, y)) {
            menuLogic.getTransitionHandler().fadeOut();
        }
    }
}