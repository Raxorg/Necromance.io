package com.frontanilla.necromance.zones.splash;

import com.frontanilla.necromance.zones.foundations.ZoneConnector;
import com.frontanilla.necromance.zones.shared.SharedConnector;
import com.frontanilla.necromance.zones.splash.logic.SplashLogic;

public class SplashConnector extends ZoneConnector {

    public SplashConnector() {
        super(new SharedConnector());
        assets = new SplashAssets();
        firebase = new SplashFirebase(sharedConnector.getSharedFirebase());
        initializer = new SplashInitializer(this);
        logic = new SplashLogic(sharedConnector.getSharedLogic());
        renderer = new SplashRenderer();
        screen = new SplashScreen(this);
        stuff = new SplashStuff(sharedConnector.getSharedStuff());
    }
}