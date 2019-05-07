package com.frontanilla.necromance.zones.menu;

import com.frontanilla.necromance.core.NecromanceClient;
import com.frontanilla.necromance.zones.foundations.ZoneConnector;
import com.frontanilla.necromance.zones.foundations.ZoneInitializer;
import com.frontanilla.necromance.zones.menu.logic.MenuLogic;
import com.frontanilla.necromance.zones.menu.logic.helpers.ButtonHandler;
import com.frontanilla.necromance.zones.menu.logic.helpers.GameAssetsHandler;
import com.frontanilla.necromance.zones.menu.logic.helpers.TransitionHandler;
import com.frontanilla.necromance.zones.menu.logic.helpers.WheelMenuHandler;
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
        // Logic
        ButtonHandler buttonHandler = new ButtonHandler();
        GameAssetsHandler gameAssetsHandler = new GameAssetsHandler();
        TransitionHandler transitionHandler = new TransitionHandler();
        WheelMenuHandler wheelMenuHandler = new WheelMenuHandler();
        // Structure Initialization
        //--------------------------
        menuAssets.initializeStructure();
        menuInput.initializeStructure(menuLogic, menuScreen);
        // Logic
        buttonHandler.initializeStructure(menuLogic, menuStuff);
        gameAssetsHandler.initializeStructure(menuAssets, menuConnector);
        transitionHandler.initializeStructure(menuLogic, menuStuff);
        wheelMenuHandler.initializeStructure(menuStuff);
        menuLogic.initializeStructure(buttonHandler, gameAssetsHandler, transitionHandler, wheelMenuHandler);

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