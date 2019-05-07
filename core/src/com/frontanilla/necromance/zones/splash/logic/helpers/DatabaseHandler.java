package com.frontanilla.necromance.zones.splash.logic.helpers;

import com.frontanilla.necromance.core.NecromanceClient;
import com.frontanilla.necromance.zones.splash.SplashFirebase;
import com.frontanilla.necromance.zones.splash.SplashStuff;

public class DatabaseHandler {

    // Structure
    private SplashFirebase splashFirebase;
    private SplashStuff splashStuff;
    // Logic
    private boolean versionUpdated;

    public void initializeStructure(SplashFirebase splashFirebase,
                                    SplashStuff splashStuff) {
        this.splashFirebase = splashFirebase;
        this.splashStuff = splashStuff;
    }

    public void initState() {
        versionUpdated = false;
        splashFirebase.fetchVersionInRealtime();
    }

    public void onVersionFetched(String version) {

        if (version.equals(NecromanceClient.VERSION)) {
            versionUpdated = true;
        } else {
            splashStuff.getMessageText().setText("Game version is old. Please update");
        }
    }

    // Getters
    public boolean isVersionUpdated() {
        return versionUpdated;
    }
}
