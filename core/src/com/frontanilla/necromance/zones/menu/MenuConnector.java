package com.frontanilla.necromance.zones.menu;

import com.frontanilla.necromance.zones.foundations.ZoneConnector;
import com.frontanilla.necromance.zones.menu.logic.MenuLogic;
import com.frontanilla.necromance.zones.menu.stuff.MenuStuff;
import com.frontanilla.necromance.zones.shared.SharedConnector;

public class MenuConnector extends ZoneConnector {

    public MenuConnector(SharedConnector sharedConnector, MenuAssets menuAssets) {
        super(sharedConnector);
        assets = menuAssets;
        initializer = new MenuInitializer(this);
        input = new MenuInput();
        logic = new MenuLogic(sharedConnector.getSharedLogic());
        renderer = new MenuRenderer();
        screen = new MenuScreen(this);
        stuff = new MenuStuff(sharedConnector.getSharedStuff());
    }
}