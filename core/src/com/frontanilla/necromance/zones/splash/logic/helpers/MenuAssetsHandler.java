package com.frontanilla.necromance.zones.splash.logic.helpers;

import com.frontanilla.necromance.zones.splash.SplashAssets;
import com.frontanilla.necromance.zones.splash.logic.SplashLogic;

public class MenuAssetsHandler {

    // Structure
    private SplashAssets splashAssets;
    private SplashLogic splashLogic;
    // Logic
    private boolean menuAssetsQueued;

    public void initializeStructure(
            SplashAssets splashAssets,
            SplashLogic splashLogic) {
        this.splashAssets = splashAssets;
        this.splashLogic = splashLogic;
    }

    public void initState() {
        splashAssets.getMenuAssets().queueAssetLoading();
        menuAssetsQueued = true;
    }

    public void update() {
        if (menuAssetsQueued) {
            if (splashAssets.getMenuAssets().getAssetManager().update()) {
                splashAssets.getMenuAssets().instantiateAssets();
                menuAssetsQueued = false;
                splashLogic.getTransitionHandler().fadeOut();
            }
        }
    }
}