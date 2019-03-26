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
        SplashLogic splashLogic = (SplashLogic) connector.getLogic();
        SplashScreen splashScreen = (SplashScreen) connector.getScreen();
        // Structure Initialization
        splashAssets.initializeStructure();
        splashLogic.initializeStructure(splashConnector, splashAssets);
        // Mandatory Initialization
        splashLogic.initState();
        // Everything is Initialized, Time to Show the Zone
        NecromanceClient.instance.setScreen(splashScreen);
    }
}
