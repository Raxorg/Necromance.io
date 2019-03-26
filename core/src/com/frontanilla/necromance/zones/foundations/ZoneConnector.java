package com.frontanilla.necromance.zones.foundations;

import com.frontanilla.necromance.zones.shared.SharedConnector;

public abstract class ZoneConnector {

    protected SharedConnector sharedConnector;
    protected ZoneAssets assets;
    protected ZoneFirebase firebase;
    protected ZoneInitializer initializer;
    protected ZoneInput input;
    protected ZoneLogic logic;
    protected ZoneRenderer renderer;
    protected ZoneScreen screen;
    protected ZoneStuff stuff;

    public ZoneConnector(SharedConnector sharedConnector) {
        this.sharedConnector = sharedConnector;
    }

    public SharedConnector getSharedConnector() {
        return sharedConnector;
    }

    public ZoneAssets getAssets() {
        return assets;
    }

    public ZoneFirebase getFirebase() {
        return firebase;
    }

    public ZoneInitializer getInitializer() {
        return initializer;
    }

    public ZoneInput getInput() {
        return input;
    }

    public ZoneLogic getLogic() {
        return logic;
    }

    public ZoneRenderer getRenderer() {
        return renderer;
    }

    public ZoneScreen getScreen() {
        return screen;
    }

    public ZoneStuff getStuff() {
        return stuff;
    }
}
