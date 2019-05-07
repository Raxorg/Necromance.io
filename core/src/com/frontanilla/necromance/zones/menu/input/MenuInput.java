package com.frontanilla.necromance.zones.menu.input;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.math.Vector3;
import com.frontanilla.necromance.zones.foundations.ZoneInput;
import com.frontanilla.necromance.zones.menu.MenuConstants;
import com.frontanilla.necromance.zones.menu.input.helpers.AdvancedInputHandler;
import com.frontanilla.necromance.zones.menu.input.helpers.BasicInputHandler;

public class MenuInput extends ZoneInput {

    // Structure
    private AdvancedInputHandler advancedInputHandler;
    private BasicInputHandler basicInputHandler;

    public void initializeStructure(
            AdvancedInputHandler advancedInputHandler,
            BasicInputHandler basicInputHandler) {
        this.advancedInputHandler = advancedInputHandler;
        this.basicInputHandler = basicInputHandler;
    }

    @Override
    public void initConfig() {
        // Configure Advanced Input
        float halfSquareSize = MenuConstants.CAMERA_HEIGHT * 0.05f;
        float tapSecondsInterval = 0.55f;
        float longPressDuration = 1.25f;
        float maxFlingDelay = 0.15f;
        advancedInputHandler.initConfig();
        basicInputHandler.initConfig();
        GestureDetector gestureDetector = new GestureDetector(
                halfSquareSize,
                tapSecondsInterval,
                longPressDuration,
                maxFlingDelay,
                advancedInputHandler
        );
        // Add Processors
        addProcessor(gestureDetector);
        addProcessor(basicInputHandler);
        // Activate Processors
        Gdx.input.setInputProcessor(this);
    }
}