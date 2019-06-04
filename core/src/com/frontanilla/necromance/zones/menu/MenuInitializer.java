package com.frontanilla.necromance.zones.menu;

import com.frontanilla.necromance.core.NecromanceClient;
import com.frontanilla.necromance.zones.foundations.ZoneConnector;
import com.frontanilla.necromance.zones.foundations.ZoneInitializer;
import com.frontanilla.necromance.zones.menu.input.MenuInput;
import com.frontanilla.necromance.zones.menu.input.helpers.AdvancedInputHandler;
import com.frontanilla.necromance.zones.menu.input.helpers.BasicInputHandler;
import com.frontanilla.necromance.zones.menu.logic.MenuLogic;
import com.frontanilla.necromance.zones.menu.logic.helpers.*;
import com.frontanilla.necromance.zones.menu.stuff.MenuStuff;

public class MenuInitializer extends ZoneInitializer {

    public MenuInitializer(ZoneConnector connector) {
        super(connector);
    }

    @Override
    public void initialize() {
        // For Ease of Use
        MenuConnector menuConnector = (MenuConnector) connector;
        MenuAssets menuAssets = (MenuAssets) connector.getAssets();
        // MenuFirebase MenuFirebase = (MenuFirebase) connector.getFirebase(); TODO
        MenuInput menuInput = (MenuInput) connector.getInput();
        MenuLogic menuLogic = (MenuLogic) connector.getLogic();
        MenuRenderer menuRenderer = (MenuRenderer) connector.getRenderer();
        MenuScreen menuScreen = (MenuScreen) connector.getScreen();
        MenuStuff menuStuff = (MenuStuff) connector.getStuff();
        // Structure Instantiation
        //-------------------------
        // Input
        AdvancedInputHandler advancedInputHandler = new AdvancedInputHandler();
        BasicInputHandler basicInputHandler = new BasicInputHandler();
        // Logic
        AudioHandler audioHandler = new AudioHandler();
        ButtonHandler buttonHandler = new ButtonHandler();
        CharacterMovementHandler characterMovementHandler = new CharacterMovementHandler();
        CharacterSelectionHandler characterSelectionHandler = new CharacterSelectionHandler();
        GameAssetsHandler gameAssetsHandler = new GameAssetsHandler();
        ProcessedInputHandler processedInputHandler = new ProcessedInputHandler();
        TransitionHandler transitionHandler = new TransitionHandler();
        WheelMenuHandler wheelMenuHandler = new WheelMenuHandler();
        // Structure Initialization
        //--------------------------
        menuAssets.initializeStructure();
        // Input
        advancedInputHandler.initializeStructure(menuInput, menuLogic, menuScreen);
        basicInputHandler.initializeStructure(menuInput, menuLogic, menuScreen);
        menuInput.initializeStructure(advancedInputHandler, basicInputHandler);
        // Logic
        audioHandler.initializeStructure(menuAssets);
        buttonHandler.initializeStructure(menuLogic, menuStuff);
        characterMovementHandler.initializeStructure(menuStuff);
        characterSelectionHandler.initializeStructure(menuScreen, menuStuff);
        gameAssetsHandler.initializeStructure(menuAssets, menuConnector);
        processedInputHandler.initializeStructure(menuLogic, menuStuff);
        transitionHandler.initializeStructure(menuInput, menuLogic, menuStuff);
        wheelMenuHandler.initializeStructure(menuStuff);
        menuLogic.initializeStructure(audioHandler, buttonHandler, characterMovementHandler, characterSelectionHandler,
                gameAssetsHandler, processedInputHandler, transitionHandler, wheelMenuHandler);

        menuRenderer.initializeStructure(menuScreen, menuStuff);
        menuStuff.initializeStructure(menuAssets, menuScreen);
        // Mandatory Initialization
        menuScreen.initCameras();
        menuRenderer.initRenderers();
        menuStuff.initStuff();
        menuInput.initConfig();
        menuLogic.initState();
        // Everything is Initialized, Time to Show the Zone
        NecromanceClient.instance.setScreen(menuScreen);
    }
}