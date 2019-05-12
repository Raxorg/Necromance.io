package com.frontanilla.necromance.zones.game.logic;

import com.frontanilla.necromance.zones.foundations.ZoneLogic;
import com.frontanilla.necromance.zones.game.logic.helpers.*;
import com.frontanilla.necromance.zones.shared.SharedLogic;

public class GameLogic extends ZoneLogic {

    // Structure
    private CameraHelper cameraHelper;
    private DatabaseHandler databaseHandler;
    private LatencyHandler latencyHandler;
    private ProcessedInputHandler processedInputHandler;
    private SpawningHandler spawningHandler;

    public GameLogic(SharedLogic sharedLogic) {
        super(sharedLogic);
    }

    public void initializeStructure(
            CameraHelper cameraHelper,
            DatabaseHandler databaseHandler,
            LatencyHandler latencyHandler,
            ProcessedInputHandler processedInputHandler,
            SpawningHandler spawningHandler) {
        this.cameraHelper = cameraHelper;
        this.databaseHandler = databaseHandler;
        this.latencyHandler = latencyHandler;
        this.processedInputHandler = processedInputHandler;
        this.spawningHandler = spawningHandler;
    }

    @Override
    public void initState() {
        cameraHelper.initState();
        databaseHandler.initState();
        latencyHandler.initState();
        processedInputHandler.initState();
        spawningHandler.initState();
    }

    @Override
    public void update(float delta) {
        latencyHandler.update(delta);
    }

    // Getters
    public DatabaseHandler getDatabaseHandler() {
        return databaseHandler;
    }

    public LatencyHandler getLatencyHandler() {
        return latencyHandler;
    }

    public ProcessedInputHandler getProcessedInputHandler() {
        return processedInputHandler;
    }
}