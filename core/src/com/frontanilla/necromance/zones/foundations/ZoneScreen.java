package com.frontanilla.necromance.zones.foundations;

import com.badlogic.gdx.ScreenAdapter;

public abstract class ZoneScreen extends ScreenAdapter {

    protected ZoneConnector connector;

    public ZoneScreen(ZoneConnector connector) {
        this.connector = connector;
    }

    @Override
    public void render(float delta) {
        connector.getLogic().update(delta);
        connector.getRenderer().render();
    }

    public abstract void initCameras();
}
