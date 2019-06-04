package com.frontanilla.necromance.zones.menu.logic.helpers;

import com.frontanilla.necromance.zones.menu.logic.MenuLogic;
import com.frontanilla.necromance.zones.menu.stuff.MenuStuff;

public class ProcessedInputHandler {

    // Structure
    private MenuLogic menuLogic;
    private MenuStuff menuStuff;

    public void initializeStructure(
            MenuLogic menuLogic,
            MenuStuff menuStuff) {
        this.menuLogic = menuLogic;
        this.menuStuff = menuStuff;
    }

    public void touchDown(float x, float y) {
        if (menuStuff.getMenuCharacter().contains(x, y)) {
            menuLogic.getCharacterSelectionHandler().touchDownOnCharacter();
        }
    }
}