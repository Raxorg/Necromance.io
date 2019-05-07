package com.frontanilla.necromance.zones.splash;

import com.frontanilla.necromance.core.NecromanceClient;
import com.frontanilla.necromance.zones.foundations.ZoneConnector;
import com.frontanilla.necromance.zones.foundations.ZoneInitializer;
import com.frontanilla.necromance.zones.splash.logic.SplashLogic;
import com.frontanilla.necromance.zones.splash.logic.helpers.DatabaseHandler;
import com.frontanilla.necromance.zones.splash.logic.helpers.MenuAssetsHandler;
import com.frontanilla.necromance.zones.splash.logic.helpers.TransitionHandler;

public class SplashInitializer extends ZoneInitializer {

    public SplashInitializer(ZoneConnector connector) {
        super(connector);
    }

    @Override
    public void initialize() {
        // For Ease of Use
        SplashConnector splashConnector = (SplashConnector) connector;
        SplashAssets splashAssets = (SplashAssets) connector.getAssets();
        SplashFirebase splashFirebase = (SplashFirebase) connector.getFirebase();
        SplashLogic splashLogic = (SplashLogic) connector.getLogic();
        SplashRenderer splashRenderer = (SplashRenderer) connector.getRenderer();
        SplashScreen splashScreen = (SplashScreen) connector.getScreen();
        SplashStuff splashStuff = (SplashStuff) connector.getStuff();
        // Structure Instantiation
        //-------------------------
        // Logic
        DatabaseHandler databaseHandler = new DatabaseHandler();
        MenuAssetsHandler menuAssetsHandler = new MenuAssetsHandler();
        TransitionHandler transitionHandler = new TransitionHandler();
        // Structure Initialization
        //--------------------------
        splashAssets.initializeStructure();
        splashFirebase.initializeStructure(splashLogic);
        // Logic
        databaseHandler.initializeStructure(splashFirebase, splashStuff);
        menuAssetsHandler.initializeStructure(splashAssets, splashLogic);
        transitionHandler.initializeStructure(splashAssets, splashConnector, splashStuff);
        splashLogic.initializeStructure(databaseHandler, menuAssetsHandler, transitionHandler);

        splashRenderer.initializeStructure(splashScreen, splashStuff);
        splashStuff.initializeStructure(splashAssets, splashScreen);
        // Mandatory Initialization
        splashAssets.queueAssetLoading(); // Special case
        splashScreen.initCameras();
        splashRenderer.initRenderers();
        splashStuff.initStuff();
        splashLogic.initState();
        // Everything is Initialized, Time to Show the Zone
        NecromanceClient.instance.setScreen(splashScreen);
    }
}
