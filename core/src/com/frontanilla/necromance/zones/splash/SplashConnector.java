package com.frontanilla.necromance.zones.splash;

import com.frontanilla.necromance.zones.foundations.ZoneConnector;
import com.frontanilla.necromance.zones.shared.SharedConnector;

public class SplashConnector extends ZoneConnector {

    public SplashConnector() {
        super(new SharedConnector());
        assets = new SplashAssets();
        initializer = new SplashInitializer(this);
        logic = new SplashLogic();
        renderer = new SplashRenderer();
        screen = new SplashScreen(this);
    }
}
