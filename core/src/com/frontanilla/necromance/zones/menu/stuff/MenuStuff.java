package com.frontanilla.necromance.zones.menu.stuff;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.frontanilla.necromance.gui.RectangleButton;
import com.frontanilla.necromance.gui.RectangleImage;
import com.frontanilla.necromance.utils.helpers.SizeUtils;
import com.frontanilla.necromance.zones.foundations.ZoneStuff;
import com.frontanilla.necromance.zones.menu.MenuAssets;
import com.frontanilla.necromance.zones.menu.MenuScreen;
import com.frontanilla.necromance.zones.shared.SharedStuff;

import static com.frontanilla.necromance.zones.menu.MenuConstants.CAMERA_WIDTH;
import static com.frontanilla.necromance.zones.menu.MenuConstants.WHEEL_RADIUS;

public class MenuStuff extends ZoneStuff {

    // Structure
    private MenuAssets menuAssets;
    private MenuScreen menuScreen;
    // Stuff
    private RectangleImage background, fader;
    private Point leftLimit, rightLimit;
    private RectangleButton playButton;
    private WheelMenu wheelMenu;
    private MenuCharacter menuCharacter;

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
        OrthographicCamera staticCamera = menuScreen.getCamera();
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
        // Limits
        leftLimit = new Point(100f, 100f);
        rightLimit = new Point(CAMERA_WIDTH - WHEEL_RADIUS, 100f);
        // Play Button
        float playButtonWidth = 200f;
        float playButtonHeight = 100f;
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
                WHEEL_RADIUS);
        wheelMenu.setPlankTexture(menuAssets.getPlank());
        // Menu Character
        float ratio = SizeUtils.getHeightToWidthRatio(menuAssets.getNecromancerDoctor());
        menuCharacter = new MenuCharacter(
                500, 100,
                300, 300 * ratio);
        menuCharacter.setTextureRegion(menuAssets.getNecromancerDoctor());
    }

    // Getters
    public RectangleImage getBackground() {
        return background;
    }

    public RectangleImage getFader() {
        return fader;
    }

    public Point getLeftLimit() {
        return leftLimit;
    }

    public Point getRightLimit() {
        return rightLimit;
    }

    public RectangleButton getPlayButton() {
        return playButton;
    }

    public WheelMenu getWheelMenu() {
        return wheelMenu;
    }

    public MenuCharacter getMenuCharacter() {
        return menuCharacter;
    }
}