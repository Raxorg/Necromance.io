package com.frontanilla.necromance.zones.splash;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.frontanilla.necromance.gui.AlignText;
import com.frontanilla.necromance.gui.RectangleImage;
import com.frontanilla.necromance.zones.foundations.ZoneStuff;
import com.frontanilla.necromance.zones.shared.SharedStuff;

import static com.frontanilla.necromance.zones.splash.SplashConstants.SPLASH_LOGO_SIZE;

public class SplashStuff extends ZoneStuff {

    // Structure
    private SplashAssets splashAssets;
    private SplashScreen splashScreen;
    // Stuff
    private RectangleImage splashLogoImage, fader;
    private AlignText messageText;

    public SplashStuff(SharedStuff sharedStuff) {
        super(sharedStuff);
    }

    public void initializeStructure(SplashAssets splashAssets,
                                    SplashScreen splashScreen) {
        this.splashAssets = splashAssets;
        this.splashScreen = splashScreen;
    }

    @Override
    public void initStuff() {
        OrthographicCamera staticCamera = splashScreen.getStaticCamera();
        // Logo
        splashLogoImage = new RectangleImage(
                staticCamera.viewportWidth / 2f - SPLASH_LOGO_SIZE / 2f,
                staticCamera.viewportHeight / 2f - SPLASH_LOGO_SIZE / 2f,
                SPLASH_LOGO_SIZE,
                SPLASH_LOGO_SIZE);
        splashLogoImage.setTextureRegion(splashAssets.getSplashLogo());
        // Fade Out Image
        fader = new RectangleImage(
                0f,
                0f,
                staticCamera.viewportWidth,
                staticCamera.viewportHeight);
        fader.setTextureRegion(splashAssets.getPixel());
        // Info Text, Tells What's Happening
        messageText = new AlignText(
                0,
                staticCamera.viewportHeight / 2f - SPLASH_LOGO_SIZE / 2f,
                staticCamera.viewportWidth,
                splashAssets.getTimesSquare(),
                false);
        messageText.setText("Checking Game Version....");
        messageText.setColor(Color.BLACK);
    }

    // Getters
    public RectangleImage getSplashLogoImage() {
        return splashLogoImage;
    }

    public RectangleImage getFader() {
        return fader;
    }

    public AlignText getMessageText() {
        return messageText;
    }
}
