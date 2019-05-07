package com.frontanilla.necromance.zones.menu.logic.helpers;

import com.frontanilla.necromance.zones.menu.stuff.MenuStuff;

public class WheelMenuHandler {

    // Structure
    private MenuStuff menuStuff;

    public void initializeStructure(MenuStuff menuStuff) {
        this.menuStuff = menuStuff;
    }

    public void initState() {

    }

    public void update(float delta) {
        menuStuff.getWheelMenu().update(delta);
    }
}
