package com.frontanilla.necromance.zones.game;

import com.frontanilla.necromance.core.NecromanceClient;
import com.frontanilla.necromance.zones.foundations.ZoneConnector;
import com.frontanilla.necromance.zones.foundations.ZoneInitializer;
import com.frontanilla.necromance.zones.game.logic.GameLogic;
import com.frontanilla.necromance.zones.game.logic.helpers.DatabaseHelper;
import com.frontanilla.necromance.zones.game.logic.helpers.LatencyHelper;
import com.frontanilla.necromance.zones.game.logic.helpers.ProcessedInputHelper;
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
        DatabaseHelper databaseHelper = new DatabaseHelper();
        LatencyHelper latencyHelper = new LatencyHelper();
        ProcessedInputHelper processedInputHelper = new ProcessedInputHelper();
        // Structure Initialization
        //--------------------------
        // Firebase
        gameFirebase.initializeStructure(gameLogic);
        // Input
        gameInput.initializeStructure(gameLogic, gameScreen, gameStuff);
        // Logic
        databaseHelper.initializeStructure(gameAssets, gameFirebase, gameInput, gameLogic, gameStuff);
        latencyHelper.initializeStructure(gameStuff);
        processedInputHelper.initializeStructure(gameFirebase, gameStuff);

        gameLogic.initializeStructure(databaseHelper, latencyHelper, processedInputHelper);
        // Renderer
        gameRenderer.initializeStructure(gameScreen, gameStuff);
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
