package com.frontanilla.necromance.zones.game.logic;

import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.frontanilla.necromance.database.clone.DBPlayer;
import com.frontanilla.necromance.database.representation.Human;
import com.frontanilla.necromance.zones.foundations.ZoneLogic;
import com.frontanilla.necromance.zones.game.logic.helpers.DatabaseHelper;
import com.frontanilla.necromance.zones.game.logic.helpers.LatencyHelper;
import com.frontanilla.necromance.zones.game.logic.helpers.ProcessedInputHelper;

public class GameLogic extends ZoneLogic {

    // Structure
    private DatabaseHelper databaseHelper;
    private LatencyHelper latencyHelper;
    private ProcessedInputHelper processedInputHelper;

    public void initializeStructure(DatabaseHelper databaseHelper, LatencyHelper latencyHelper,
                                    ProcessedInputHelper processedInputHelper) {
        this.databaseHelper = databaseHelper;
        this.latencyHelper = latencyHelper;
        this.processedInputHelper = processedInputHelper;
    }

    @Override
    public void initState() {
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