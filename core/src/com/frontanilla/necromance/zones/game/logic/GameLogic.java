package com.frontanilla.necromance.zones.game.logic;

import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.frontanilla.necromance.database.clone.DBPlayerDocument;
import com.frontanilla.necromance.database.representation.Human;
import com.frontanilla.necromance.zones.foundations.ZoneLogic;
import com.frontanilla.necromance.zones.game.logic.helpers.CameraHelper;
import com.frontanilla.necromance.zones.game.logic.helpers.DatabaseHandler;
import com.frontanilla.necromance.zones.game.logic.helpers.LatencyHandler;
import com.frontanilla.necromance.zones.game.logic.helpers.ProcessedInputHandler;
import com.frontanilla.necromance.zones.shared.SharedLogic;

public class GameLogic extends ZoneLogic {

    // Structure
    private CameraHelper cameraHelper;
    private DatabaseHandler databaseHandler;
    private LatencyHandler latencyHandler;
    private ProcessedInputHandler processedInputHandler;

    public GameLogic(SharedLogic sharedLogic) {
        super(sharedLogic);
    }

    public void initializeStructure(CameraHelper cameraHelper, DatabaseHandler databaseHandler, LatencyHandler latencyHandler,
                                    ProcessedInputHandler processedInputHandler) {
        this.cameraHelper = cameraHelper;
        this.databaseHandler = databaseHandler;
        this.latencyHandler = latencyHandler;
        this.processedInputHandler = processedInputHandler;
    }

    @Override
    public void initState() {
        cameraHelper.initState();
        databaseHandler.initState();
        latencyHandler.initState();
        processedInputHandler.initState();
    }

    @Override
    public void update(float delta) {
        latencyHandler.update(delta);
    }

    // Called by GameFirebase
    public void onPlayersFetched(DelayedRemovalArray<DBPlayerDocument> players) {
        databaseHandler.onPlayersFetched(players);
    }

    public void onMovePlayerStartTime() {
        latencyHandler.onMovePlayerStartTime();
    }

    public void onMovePlayerStopTime() {
        latencyHandler.onMovePlayerStopTime();
    }

    // Called by GameInput
    public void touchDownOnHumanPlayer(Human humanPlayer) {
        processedInputHandler.touchDownOnHumanPlayer(humanPlayer);
    }

    public void touchDownOnEmptySpace(int x, int y) {
        processedInputHandler.touchDownOnEmptySpace(x, y);
    }

    // Getters
    public DatabaseHandler getDatabaseHandler() {
        return databaseHandler;
    }
}