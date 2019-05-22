package com.frontanilla.necromance.zones.game;

import com.frontanilla.necromance.core.NecromanceClient;
import com.frontanilla.necromance.zones.foundations.ZoneConnector;
import com.frontanilla.necromance.zones.foundations.ZoneInitializer;
import com.frontanilla.necromance.zones.game.logic.GameLogic;
import com.frontanilla.necromance.zones.game.logic.helpers.*;
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
        GameNetworked gameNetworked = (GameNetworked) connector.getNetworked();
        GameRenderer gameRenderer = (GameRenderer) connector.getRenderer();
        GameScreen gameScreen = (GameScreen) connector.getScreen();
        GameStuff gameStuff = (GameStuff) connector.getStuff();
        // Structure Instantiation
        //-------------------------
        CameraHelper cameraHelper = new CameraHelper();
        DatabaseHandler databaseHandler = new DatabaseHandler();
        LatencyHandler latencyHandler = new LatencyHandler();
        MessageHandler messageHandler = new MessageHandler();
        ProcessedInputHandler processedInputHandler = new ProcessedInputHandler();
        SpawningHandler spawningHandler = new SpawningHandler();
        // Structure Initialization
        //--------------------------
        // Firebase
        gameFirebase.initializeStructure(gameLogic);
        // Input
        gameInput.initializeStructure(gameLogic, gameScreen, gameNetworked);
        // Logic
        cameraHelper.initializeStructure(gameScreen, gameStuff);
        databaseHandler.initializeStructure(gameAssets, gameFirebase, gameInput, gameLogic, gameNetworked);
        latencyHandler.initializeStructure(gameNetworked);
        messageHandler.initializeStructure(gameStuff);
        processedInputHandler.initializeStructure(gameFirebase, gameLogic, gameNetworked, gameStuff);
        spawningHandler.initializeStructure(gameNetworked);

        gameLogic.initializeStructure(cameraHelper, databaseHandler, latencyHandler, messageHandler, processedInputHandler, spawningHandler);
        // Renderer
        gameRenderer.initializeStructure(gameNetworked, gameScreen, gameStuff);
        // Stuff
        gameStuff.initializeStructure(gameAssets);
        // Mandatory Initialization
        //--------------------------
        gameScreen.initCameras();
        gameRenderer.initRenderers();
        gameStuff.initStuff();
        gameNetworked.initNetworked();
        gameInput.initConfig();
        gameLogic.initState();
        // Everything is Initialized, Time to Show the Zone
        NecromanceClient.instance.setScreen(gameScreen);
    }
}