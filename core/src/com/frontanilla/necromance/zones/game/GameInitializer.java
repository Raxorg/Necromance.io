package com.frontanilla.necromance.zones.game;

import com.frontanilla.necromance.core.NecromanceClient;
import com.frontanilla.necromance.zones.foundations.ZoneConnector;
import com.frontanilla.necromance.zones.foundations.ZoneInitializer;
import com.frontanilla.necromance.zones.game.logic.GameLogic;
import com.frontanilla.necromance.zones.game.logic.helpers.CameraHelper;
import com.frontanilla.necromance.zones.game.logic.helpers.DatabaseHandler;
import com.frontanilla.necromance.zones.game.logic.helpers.LatencyHandler;
import com.frontanilla.necromance.zones.game.logic.helpers.ProcessedInputHandler;
import com.frontanilla.necromance.zones.game.stuff.GameStuff;

public class GameInitializer extends ZoneInitializer {

    public GameInitializer(ZoneConnector connector) {
        super(connector);
    }

    @Override
    public void initialize() {
        // For Ease of Use
        //-----------------
        GameAssets gameAssets = (GameAssets) connector.getAssets();
        GameFirebase gameFirebase = (GameFirebase) connector.getFirebase();
        GameInput gameInput = (GameInput) connector.getInput();
        GameLogic gameLogic = (GameLogic) connector.getLogic();
        GameRenderer gameRenderer = (GameRenderer) connector.getRenderer();
        GameScreen gameScreen = (GameScreen) connector.getScreen();
        GameStuff gameStuff = (GameStuff) connector.getStuff();
        // Structure Instantiation
        //-------------------------
        CameraHelper cameraHelper = new CameraHelper();
        DatabaseHandler databaseHandler = new DatabaseHandler();
        LatencyHandler latencyHandler = new LatencyHandler();
        ProcessedInputHandler processedInputHandler = new ProcessedInputHandler();
        // Structure Initialization
        //--------------------------
        // Firebase
        gameFirebase.initializeStructure(gameLogic);
        // Input
        gameInput.initializeStructure(gameLogic, gameScreen, gameStuff);
        // Logic
        cameraHelper.initializeStructure(gameScreen, gameStuff);
        databaseHandler.initializeStructure(gameAssets, gameFirebase, gameInput, gameLogic, gameStuff);
        latencyHandler.initializeStructure(gameStuff);
        processedInputHandler.initializeStructure(gameFirebase, gameStuff);

        gameLogic.initializeStructure(cameraHelper, databaseHandler, latencyHandler, processedInputHandler);
        // Renderer
        gameRenderer.initializeStructure(gameScreen, gameStuff);
        // Stuff
        gameStuff.initializeStructure(gameAssets);
        // Mandatory Initialization
        //--------------------------
        gameScreen.initCameras();
        gameRenderer.initRenderers();
        gameStuff.initStuff();
        gameInput.initConfig();
        gameLogic.initState();
        // Everything is Initialized, Time to Show the Zone
        NecromanceClient.instance.setScreen(gameScreen);
    }
}
