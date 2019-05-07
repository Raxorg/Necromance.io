package com.frontanilla.necromance.zones.menu.logic;

import com.frontanilla.necromance.zones.foundations.ZoneLogic;
import com.frontanilla.necromance.zones.menu.logic.helpers.ButtonHandler;
import com.frontanilla.necromance.zones.menu.logic.helpers.GameAssetsHandler;
import com.frontanilla.necromance.zones.menu.logic.helpers.TransitionHandler;
import com.frontanilla.necromance.zones.menu.logic.helpers.WheelMenuHandler;
import com.frontanilla.necromance.zones.shared.SharedLogic;

public class MenuLogic extends ZoneLogic {

    // Structure
    private ButtonHandler buttonHandler;
    private GameAssetsHandler gameAssetsHandler;
    private TransitionHandler transitionHandler;
    private WheelMenuHandler wheelMenuHandler;

    public MenuLogic(SharedLogic sharedLogic) {
        super(sharedLogic);
    }

    public void initializeStructure(
            ButtonHandler buttonHandler,
            GameAssetsHandler gameAssetsHandler,
            TransitionHandler transitionHandler,
            WheelMenuHandler wheelMenuHandler) {
        this.buttonHandler = buttonHandler;
        this.gameAssetsHandler = gameAssetsHandler;
        this.transitionHandler = transitionHandler;
        this.wheelMenuHandler = wheelMenuHandler;
    }

    @Override
    public void initState() {
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
}