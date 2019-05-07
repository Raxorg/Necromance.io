package com.frontanilla.necromance.zones.menu.logic.helpers;

import com.frontanilla.necromance.core.NecromanceClient;
import com.frontanilla.necromance.zones.game.GameConnector;
import com.frontanilla.necromance.zones.menu.MenuAssets;
import com.frontanilla.necromance.zones.menu.MenuConnector;

public class GameAssetsHandler {

    // Structure
    private MenuAssets menuAssets;
    private MenuConnector menuConnector;
    // Logic
    private boolean gameAssetsQueued;

    public void initializeStructure(
            MenuAssets menuAssets,
            MenuConnector menuConnector) {
        this.menuAssets = menuAssets;
        this.menuConnector = menuConnector;
    }

    public void queueAssetLoading() {
        menuAssets.getGameAssets().queueAssetLoading();
        gameAssetsQueued = true;
    }

    public void update() {
        if (gameAssetsQueued) {
            if (menuAssets.getGameAssets().getAssetManager().update()) {
                menuAssets.getGameAssets().instantiateAssets();
                GameConnector gameConnector = new GameConnector(
                        menuConnector.getSharedConnector(),
                        menuAssets.getGameAssets());
                NecromanceClient.instance.enterZone(gameConnector);
                gameAssetsQueued = false;
            }
        }
    }
}