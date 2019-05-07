package com.frontanilla.necromance.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.frontanilla.necromance.core.NecromanceClient;

public class DesktopLauncher {
    public static void main(String[] arg) {
        LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
        config.width = 1800;
        config.height = 900;
        new LwjglApplication(new NecromanceClient("DESKTOP", new DesktopRealtimeDB(), new DesktopAuth()), config);
    }
}