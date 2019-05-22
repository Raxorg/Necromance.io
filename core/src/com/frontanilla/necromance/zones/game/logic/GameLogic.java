package com.frontanilla.necromance.zones.game.logic;

import com.frontanilla.necromance.zones.foundations.ZoneLogic;
import com.frontanilla.necromance.zones.game.logic.helpers.*;
import com.frontanilla.necromance.zones.game.logic.testing.EnemyHandler;
import com.frontanilla.necromance.zones.shared.SharedLogic;

public class GameLogic extends ZoneLogic {

    // Structure
    private CameraHelper cameraHelper;
    private DatabaseHandler databaseHandler;
    private LatencyHandler latencyHandler;
    private MessageHandler messageHandler;
    private ProcessedInputHandler processedInputHandler;
    private SpawningHandler spawningHandler;
    // Testing
    private EnemyHandler enemyHandler;

    public GameLogic(SharedLogic sharedLogic) {
        super(sharedLogic);
    }

    public void initializeStructure(
            CameraHelper cameraHelper,
            DatabaseHandler databaseHandler,
            LatencyHandler latencyHandler,
            MessageHandler messageHandler,
            ProcessedInputHandler processedInputHandler,
            SpawningHandler spawningHandler,
            EnemyHandler enemyHandler) {
        this.cameraHelper = cameraHelper;
        this.databaseHandler = databaseHandler;
        this.latencyHandler = latencyHandler;
        this.messageHandler = messageHandler;
        this.processedInputHandler = processedInputHandler;
        this.spawningHandler = spawningHandler;
        this.enemyHandler = enemyHandler;
    }

    @Override
    public void initState() {
        cameraHelper.initState();
        databaseHandler.initState();
        latencyHandler.initState();
        messageHandler.initState();
        processedInputHandler.initState();
        spawningHandler.initState();
    }

    @Override
    public void update(float delta) {
        latencyHandler.update(delta);
        messageHandler.update(delta);
    }

    // Getters
    public DatabaseHandler getDatabaseHandler() {
        return databaseHandler;
    }

    public LatencyHandler getLatencyHandler() {
        return latencyHandler;
    }

    public MessageHandler getMessageHandler() {
        return messageHandler;
    }

    public ProcessedInputHandler getProcessedInputHandler() {
        return processedInputHandler;
    }

    public EnemyHandler getEnemyHandler() {
        return enemyHandler;
    }
}