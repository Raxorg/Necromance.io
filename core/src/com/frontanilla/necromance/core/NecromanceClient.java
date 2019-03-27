package com.frontanilla.necromance.core;

import com.badlogic.gdx.Game;
import com.frontanilla.necromance.interfacing.firebase.RealtimeDBInterface;
import com.frontanilla.necromance.zones.foundations.ZoneConnector;
import com.frontanilla.necromance.zones.splash.SplashConnector;

public class NecromanceClient extends Game {

    public static final String VERSION = "0.0.2";
    public static NecromanceClient instance;
    private String phoneID;
    private RealtimeDBInterface realtimeDBInterface;

    public NecromanceClient(String phoneIdentifier, RealtimeDBInterface realtimeDBInterface) {
        phoneID = phoneIdentifier;
        this.realtimeDBInterface = realtimeDBInterface;
        instance = this;
    }

    @Override
    public void create() {
        // Catch all fucking errors?
        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println(t + " throws exception: " + e);
                e.printStackTrace();
            }
        });

        // Rock and roll
        enterZone(new SplashConnector());
    }

    public void enterZone(ZoneConnector zoneConnector) {
        zoneConnector.getInitializer().initialize();
    }

    // Getters
    public String getPhoneID() {
        return phoneID;
    }

    public RealtimeDBInterface getRealtimeDBInterface() {
        return realtimeDBInterface;
    }
}