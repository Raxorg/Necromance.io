package com.frontanilla.necromance.zones.game.logic;

import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.frontanilla.necromance.database.clone.DBPlayer;
import com.frontanilla.necromance.database.representation.Human;
import com.frontanilla.necromance.zones.foundations.ZoneLogic;
import com.frontanilla.necromance.zones.game.logic.helpers.CameraHelper;
import com.frontanilla.necromance.zones.game.logic.helpers.DatabaseHelper;
import com.frontanilla.necromance.zones.game.logic.helpers.LatencyHelper;
import com.frontanilla.necromance.zones.game.logic.helpers.ProcessedInputHelper;
import com.frontanilla.necromance.zones.shared.SharedLogic;

public class GameLogic extends ZoneLogic {

    // Structure
    private CameraHelper cameraHelper;
    private DatabaseHelper databaseHelper;
    private LatencyHelper latencyHelper;
    private ProcessedInputHelper processedInputHelper;

    public GameLogic(SharedLogic sharedLogic) {
        super(sharedLogic);
    }

    public void initializeStructure(CameraHelper cameraHelper, DatabaseHelper databaseHelper, LatencyHelper latencyHelper,
                                    ProcessedInputHelper processedInputHelper) {
        this.cameraHelper = cameraHelper;
        this.databaseHelper = databaseHelper;
        this.latencyHelper = latencyHelper;
        this.processedInputHelper = processedInputHelper;
    }

    @Override
    public void initState() {
        cameraHelper.initState();
        databaseHelper.initState();
        latencyHelper.initState();
        processedInputHelper.initState();
    }

    @Override
    public void update(float delta) {
        latencyHelper.update(delta);
    }

    // Called by GameFirebase
    public void onPlayersFetched(DelayedRemovalArray<DBPlayer> players) {
        databaseHelper.onPlayersFetched(players);
    }

    public void onMovePlayerStartTime() {
        latencyHelper.onMovePlayerStartTime();
    }

    public void onMovePlayerStopTime() {
        latencyHelper.onMovePlayerStopTime();
    }

    // Called by GameInput
    public void touchDownOnHumanPlayer(Human humanPlayer) {
        processedInputHelper.touchDownOnHumanPlayer(humanPlayer);
    }

    public void touchDownOnEmptySpace(int x, int y) {
        processedInputHelper.touchDownOnEmptySpace(x, y);
    }
}