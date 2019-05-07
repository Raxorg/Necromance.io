package com.frontanilla.necromance.zones.splash.logic;

import com.frontanilla.necromance.zones.foundations.ZoneLogic;
import com.frontanilla.necromance.zones.shared.SharedLogic;
import com.frontanilla.necromance.zones.splash.logic.helpers.DatabaseHandler;
import com.frontanilla.necromance.zones.splash.logic.helpers.MenuAssetsHandler;
import com.frontanilla.necromance.zones.splash.logic.helpers.TransitionHandler;

public class SplashLogic extends ZoneLogic {

    // Structure
    private DatabaseHandler databaseHandler;
    private MenuAssetsHandler menuAssetsHandler;
    private TransitionHandler transitionHandler;

    public SplashLogic(SharedLogic sharedLogic) {
        super(sharedLogic);
    }

    public void initializeStructure(
            DatabaseHandler databaseHandler,
            MenuAssetsHandler menuAssetsHandler,
            TransitionHandler transitionHandler) {
        this.databaseHandler = databaseHandler;
        this.menuAssetsHandler = menuAssetsHandler;
        this.transitionHandler = transitionHandler;
    }

    @Override
    public void initState() {
        menuAssetsHandler.initState();
        databaseHandler.initState();
        transitionHandler.initState();
    }

    @Override
    public void update(float delta) {
        if (databaseHandler.isVersionUpdated()) {
            menuAssetsHandler.update();
            transitionHandler.update(delta);
        }
    }

    // Getters
    public DatabaseHandler getDatabaseHandler() {
        return databaseHandler;
    }

    public TransitionHandler getTransitionHandler() {
        return transitionHandler;
    }
}