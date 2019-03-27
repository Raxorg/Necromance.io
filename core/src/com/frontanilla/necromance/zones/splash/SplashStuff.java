package com.frontanilla.necromance.zones.splash;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.frontanilla.necromance.gui.Text;
import com.frontanilla.necromance.zones.foundations.ZoneStuff;
import com.frontanilla.necromance.zones.shared.SharedStuff;

public class SplashStuff extends ZoneStuff {

    // Structure
    private SplashAssets splashAssets;
    private SplashScreen splashScreen;
    // Stuff
    private Text messageText;

    public SplashStuff(SharedStuff sharedStuff) {
        super(sharedStuff);
    }

    public void initializeStructure(SplashAssets splashAssets, SplashScreen splashScreen) {
        this.splashAssets = splashAssets;
        this.splashScreen = splashScreen;
    }

    @Override
    public void initStuff() {
        OrthographicCamera staticCamera = splashScreen.getStaticCamera();
        messageText = new Text(
                0,
                staticCamera.viewportHeight / 2f,
                staticCamera.viewportWidth,
                splashAssets.getTimesSquare());
        messageText.setText("Checking Game Version....");
        messageText.setColor(Color.BLACK);
    }

    // Getters
    public Text getMessageText() {
        return messageText;
    }
}
