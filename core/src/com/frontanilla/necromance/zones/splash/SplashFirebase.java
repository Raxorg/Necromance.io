package com.frontanilla.necromance.zones.splash;

import com.frontanilla.necromance.utils.advanced.ChangeListener;
import com.frontanilla.necromance.zones.foundations.ZoneFirebase;
import com.frontanilla.necromance.zones.shared.SharedFirebase;

public class SplashFirebase extends ZoneFirebase {

    // Structure
    private SplashLogic splashLogic;

    public SplashFirebase(SharedFirebase sharedFirebase) {
        super(sharedFirebase);
    }

    public void initializeStructure(SplashLogic splashLogic) {
        this.splashLogic = splashLogic;
    }

    //-------------------
    // Realtime Fetching
    //-------------------
    public void fetchVersionInRealtime() {
        sharedFirebase.fetchVersionInRealtime(new ChangeListener<String>() {
            @Override
            public void onCancelled(String message) {
                System.out.println("CANCELLED: " + message);
            }

            @Override
            public void onDataFetched(String  version) {
                System.out.println("Version Fetched: " + version);
                splashLogic.onVersionFetched(version);
            }
        });
    }
}
