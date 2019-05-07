package com.frontanilla.necromance.zones.menu.logic.helpers;

import com.frontanilla.necromance.zones.menu.MenuAssets;

public class AudioHandler {

    private MenuAssets menuAssets;

    public void initializeStructure(MenuAssets menuAssets) {
        this.menuAssets = menuAssets;
    }

    public void initState() {
        menuAssets.getMedieval().play();
        menuAssets.getMedieval().setLooping(true);
    }
}