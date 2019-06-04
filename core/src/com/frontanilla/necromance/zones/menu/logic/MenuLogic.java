package com.frontanilla.necromance.zones.menu.logic;

import com.frontanilla.necromance.zones.foundations.ZoneLogic;
import com.frontanilla.necromance.zones.menu.logic.helpers.*;
import com.frontanilla.necromance.zones.shared.SharedLogic;

public class MenuLogic extends ZoneLogic {

    // Structure
    private AudioHandler audioHandler;
    private ButtonHandler buttonHandler;
    private CharacterMovementHandler characterMovementHandler;
    private CharacterSelectionHandler characterSelectionHandler;
    private GameAssetsHandler gameAssetsHandler;
    private ProcessedInputHandler processedInputHandler;
    private TransitionHandler transitionHandler;
    private WheelMenuHandler wheelMenuHandler;

    public MenuLogic(SharedLogic sharedLogic) {
        super(sharedLogic);
    }

    public void initializeStructure(
            AudioHandler audioHandler,
            ButtonHandler buttonHandler,
            CharacterMovementHandler characterMovementHandler,
            CharacterSelectionHandler characterSelectionHandler,
            GameAssetsHandler gameAssetsHandler,
            ProcessedInputHandler processedInputHandler,
            TransitionHandler transitionHandler,
            WheelMenuHandler wheelMenuHandler) {
        this.audioHandler = audioHandler;
        this.buttonHandler = buttonHandler;
        this.characterMovementHandler = characterMovementHandler;
        this.characterSelectionHandler = characterSelectionHandler;
        this.gameAssetsHandler = gameAssetsHandler;
        this.processedInputHandler = processedInputHandler;
        this.transitionHandler = transitionHandler;
        this.wheelMenuHandler = wheelMenuHandler;
    }

    @Override
    public void initState() {
        audioHandler.initState();
        buttonHandler.initState();
        characterMovementHandler.initState();
        characterSelectionHandler.initState();
        transitionHandler.initState();
        wheelMenuHandler.initState();
    }

    @Override
    public void update(float delta) {
        characterMovementHandler.update(delta);
        characterSelectionHandler.update(delta);
        gameAssetsHandler.update();
        transitionHandler.update(delta);
        wheelMenuHandler.update(delta);
    }

    // Getters
    public ButtonHandler getButtonHandler() {
        return buttonHandler;
    }

    public CharacterSelectionHandler getCharacterSelectionHandler() {
        return characterSelectionHandler;
    }

    public GameAssetsHandler getGameAssetsHandler() {
        return gameAssetsHandler;
    }

    public ProcessedInputHandler getProcessedInputHandler() {
        return processedInputHandler;
    }

    public TransitionHandler getTransitionHandler() {
        return transitionHandler;
    }

    public WheelMenuHandler getWheelMenuHandler() {
        return wheelMenuHandler;
    }
}