package com.frontanilla.necromance.zones.menu;

import com.badlogic.gdx.Gdx;

public class MenuConstants {

    // Assets
    public static final String TIMES_SQUARE_FILE = "fonts/timesSquare.fnt";
    public static final String MENU_ATLAS_FILE = "images/menu/menuAtlas.png";
    public static final String MEDIEVAL_MUSIC_FILE = "audio/menu/medieval.mp3";
    public static final String CHARACTER_ATLAS_FILE = "images/game/characterAtlas.png";
    // Logic
    public static final float FADING_DURATION = 1f;
    public static final float WHEEL_FLING_VELOCITY_MODIFIER = 0.001f;
    // Screen
    public static final float SCREEN_WIDTH = Gdx.graphics.getWidth();
    public static final float SCREEN_HEIGHT = Gdx.graphics.getHeight();
    public static final float SCREEN_RATIO = SCREEN_WIDTH / SCREEN_HEIGHT;
    public static final float CAMERA_HEIGHT = 1000f;
    public static final float CAMERA_WIDTH = 1000f * SCREEN_RATIO;
    // Stuff
    public static final float WHEEL_RADIUS = CAMERA_HEIGHT / 2f;
    public static final float WHEEL_PLANK_WIDTH = 300;
    public static final float WHEEL_PLANK_HEIGHT = 150;
}
