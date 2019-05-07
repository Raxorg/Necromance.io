package com.frontanilla.necromance.zones.menu.stuff;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.frontanilla.necromance.gui.RectangleButton;
import com.frontanilla.necromance.gui.RectangleImage;
import com.frontanilla.necromance.zones.foundations.ZoneStuff;
import com.frontanilla.necromance.zones.menu.MenuAssets;
import com.frontanilla.necromance.zones.menu.MenuScreen;
import com.frontanilla.necromance.zones.shared.SharedStuff;

public class MenuStuff extends ZoneStuff {

    // Structure
    private MenuAssets menuAssets;
    private MenuScreen menuScreen;
    // Stuff
    private RectangleImage background, fader;
    private RectangleButton playButton;
    private WheelMenu wheelMenu;

    public MenuStuff(SharedStuff sharedStuff) {
        super(sharedStuff);
    }

    public void initializeStructure(
            MenuAssets menuAssets,
            MenuScreen menuScreen) {
        this.menuAssets = menuAssets;
        this.menuScreen = menuScreen;
    }

    @Override
    public void initStuff() {
        OrthographicCamera staticCamera = menuScreen.getStaticCamera();
        // Background
        background = new RectangleImage(
                0,
                0,
                staticCamera.viewportWidth,
                staticCamera.viewportHeight);
        background.setTextureRegion(menuAssets.getBackground());
        // Fade Out Image
        fader = new RectangleImage(
                0f,
                0f,
                staticCamera.viewportWidth,
                staticCamera.viewportHeight);
        fader.setTextureRegion(menuAssets.getPixel());
        // Play Button
        float playButtonWidth = 200;
        float playButtonHeight = 100;
        playButton = new RectangleButton(
                staticCamera.viewportWidth / 2f - playButtonWidth / 2f,
                staticCamera.viewportHeight / 2f - playButtonHeight / 2f,
                playButtonWidth,
                playButtonHeight);
        playButton.setTextureRegion(menuAssets.getPlank());
        // Wheel Menu
        wheelMenu = new WheelMenu(
                staticCamera.viewportWidth,
                staticCamera.viewportHeight / 2f,
                staticCamera.viewportHeight / 2f);
        wheelMenu.setPlankTexture(menuAssets.getPlank());
    }

    // Getters
    public RectangleImage getBackground() {
        return background;
    }

    public RectangleImage getFader() {
        return fader;
    }

    public RectangleButton getPlayButton() {
        return playButton;
    }

    public WheelMenu getWheelMenu() {
        return wheelMenu;
    }
}