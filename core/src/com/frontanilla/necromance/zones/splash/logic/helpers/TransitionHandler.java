package com.frontanilla.necromance.zones.splash.logic.helpers;

import com.badlogic.gdx.graphics.Color;
import com.frontanilla.necromance.core.NecromanceClient;
import com.frontanilla.necromance.zones.menu.MenuConnector;
import com.frontanilla.necromance.zones.splash.SplashAssets;
import com.frontanilla.necromance.zones.splash.SplashConnector;
import com.frontanilla.necromance.zones.splash.SplashStuff;

import static com.frontanilla.necromance.zones.splash.SplashConstants.FADING_DURATION;

public class TransitionHandler {

    // Structure
    private SplashAssets splashAssets;
    private SplashConnector splashConnector;
    private SplashStuff splashStuff;
    // Logic
    private float alpha;
    private boolean started;

    public void initializeStructure(SplashAssets splashAssets,
                                    SplashConnector splashConnector,
                                    SplashStuff splashStuff) {
        this.splashAssets = splashAssets;
        this.splashConnector = splashConnector;
        this.splashStuff = splashStuff;
    }

    public void initState() {
        alpha = 0;
        splashStuff.getFader().setColor(Color.CLEAR);
    }

    public void fadeOut() {
        started = true;
    }

    public void update(float delta) {
        if (started) {
            alpha += delta / FADING_DURATION;
            splashStuff.getFader().setColor(new Color(1, 1, 1, alpha));
            if (alpha >= 1) {
                started = false;
                MenuConnector menuConnector = new MenuConnector(
                        splashConnector.getSharedConnector(),
                        splashAssets.getMenuAssets());
                NecromanceClient.instance.enterZone(menuConnector);
            }
        }
    }
}