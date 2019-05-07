package com.frontanilla.necromance.zones.menu.logic;

import com.frontanilla.necromance.zones.foundations.ZoneLogic;
import com.frontanilla.necromance.zones.menu.logic.helpers.*;
import com.frontanilla.necromance.zones.shared.SharedLogic;

public class MenuLogic extends ZoneLogic {

    // Structure
    private AudioHandler audioHandler;
    private ButtonHandler buttonHandler;
    private GameAssetsHandler gameAssetsHandler;
    private TransitionHandler transitionHandler;
    private WheelMenuHandler wheelMenuHandler;

    public MenuLogic(SharedLogic sharedLogic) {
        super(sharedLogic);
    }

    public void initializeStructure(
            AudioHandler audioHandler,
            ButtonHandler buttonHandler,
            GameAssetsHandler gameAssetsHandler,
            TransitionHandler transitionHandler,
            WheelMenuHandler wheelMenuHandler) {
        this.audioHandler = audioHandler;
        this.buttonHandler = buttonHandler;
        this.gameAssetsHandler = gameAssetsHandler;
        this.transitionHandler = transitionHandler;
        this.wheelMenuHandler = wheelMenuHandler;
    }

    @Override
    public void initState() {
        audioHandler.initState();
        buttonHandler.initState();
        transitionHandler.initState();
        wheelMenuHandler.initState();
    }

    @Override
    public void update(float delta) {
        gameAssetsHandler.update();
        transitionHandler.update(delta);
        wheelMenuHandler.update(delta);
    }

    // Getters
    public ButtonHandler getButtonHandler() {
        return buttonHandler;
    }

    public GameAssetsHandler getGameAssetsHandler() {
        return gameAssetsHandler;
    }

    public TransitionHandler getTransitionHandler() {
        return transitionHandler;
    }

    public WheelMenuHandler getWheelMenuHandler() {
        return wheelMenuHandler;
    }
}