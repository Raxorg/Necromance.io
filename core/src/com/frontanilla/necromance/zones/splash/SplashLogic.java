package com.frontanilla.necromance.zones.splash;

import com.frontanilla.necromance.core.NecromanceClient;
import com.frontanilla.necromance.zones.foundations.ZoneLogic;
import com.frontanilla.necromance.zones.game.GameConnector;
import com.frontanilla.necromance.zones.shared.SharedLogic;

public class SplashLogic extends ZoneLogic {

    // Structure
    private SplashConnector splashConnector;
    private SplashAssets splashAssets;
    private SplashFirebase splashFirebase;
    private SplashStuff splashStuff;
    // Logic
    private boolean versionUpdated;
    private boolean gameAssetsQueued;

    public SplashLogic(SharedLogic sharedLogic) {
        super(sharedLogic);
    }

    public void initializeStructure(SplashConnector splashConnector, SplashAssets splashAssets, SplashFirebase splashFirebase,
                                    SplashStuff splashStuff) {
        this.splashConnector = splashConnector;
        this.splashAssets = splashAssets;
        this.splashFirebase = splashFirebase;
        this.splashStuff = splashStuff;
    }

    @Override
    public void initState() {
        versionUpdated = false;
        splashAssets.getGameAssets().queueAssetLoading();
        gameAssetsQueued = true;
        splashFirebase.fetchVersionInRealtime();
    }

    @Override
    public void update(float delta) {
        if (versionUpdated) {
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

    public void onVersionFetched(String version) {
        if (version.equals(NecromanceClient.VERSION)) {
            versionUpdated = true;
        } else {
            splashStuff.getMessageText().setText("Game version is old. Please update");
        }
    }
}
