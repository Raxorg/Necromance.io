package com.frontanilla.necromance.core;

import com.badlogic.gdx.Game;
import com.frontanilla.necromance.interfacing.firebase.AuthInterface;
import com.frontanilla.necromance.interfacing.firebase.RealtimeDBInterface;
import com.frontanilla.necromance.zones.foundations.ZoneConnector;
import com.frontanilla.necromance.zones.splash.SplashConnector;

public class NecromanceClient extends Game {

    public static final String VERSION = "0.0.2";
    public static NecromanceClient instance;
    private String phoneID;
    private RealtimeDBInterface realtimeDBInterface;
    private AuthInterface authInterface;

    public NecromanceClient(String phoneIdentifier, RealtimeDBInterface realtimeDBInterface, AuthInterface authInterface) {
        phoneID = phoneIdentifier;
        this.realtimeDBInterface = realtimeDBInterface;
        this.authInterface = authInterface;
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

    public AuthInterface getAuthInterface() {
        return authInterface;
    }
}