package com.frontanilla.necromance.zones.splash;

import com.frontanilla.necromance.core.NecromanceClient;
import com.frontanilla.necromance.zones.foundations.ZoneConnector;
import com.frontanilla.necromance.zones.foundations.ZoneInitializer;

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
        // Structure Initialization
        splashAssets.initializeStructure();
        splashFirebase.initializeStructure(splashLogic);
        splashLogic.initializeStructure(splashConnector, splashAssets, splashFirebase, splashStuff);
        splashRenderer.initializeStructure(splashScreen, splashStuff);
        splashStuff.initializeStructure(splashAssets, splashScreen);
        // Mandatory Initialization
        splashAssets.queueAssetLoading();
        splashScreen.initCameras();
        splashRenderer.initRenderers();
        splashStuff.initStuff();
        splashLogic.initState();
        // Everything is Initialized, Time to Show the Zone
        NecromanceClient.instance.setScreen(splashScreen);
    }
}
