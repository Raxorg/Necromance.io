package com.frontanilla.necromance.zones.splash;

import com.frontanilla.necromance.core.NecromanceClient;
import com.frontanilla.necromance.zones.foundations.ZoneLogic;
import com.frontanilla.necromance.zones.game.GameConnector;

public class SplashLogic extends ZoneLogic {

    // Structure
    private SplashConnector splashConnector;
    private SplashAssets splashAssets;
    // Logic
    private boolean gameAssetsQueued;

    public void initializeStructure(SplashConnector splashConnector, SplashAssets splashAssets) {
        this.splashConnector = splashConnector;
        this.splashAssets = splashAssets;
    }

    @Override
    public void initState() {
        splashAssets.getGameAssets().queueAssetLoading();
        gameAssetsQueued = true;
    }

    @Override
    public void update(float delta) {
        if (gameAssetsQueued) {
            if (splashAssets.getGameAssets().getAssetManager().update()) {
                splashAssets.getGameAssets().instantiateAssets();
                GameConnector gameConnector = new GameConnector(
                        splashConnector.getSharedConnector(),
                        splashAssets.getGameAssets());
                NecromanceClient.instance.enterZone(gameConnector);
                gameAssetsQueued = false;
            }
        }
    }
}
