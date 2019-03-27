package com.frontanilla.necromance.zones.game.logic.helpers;

import com.frontanilla.necromance.database.representation.Human;
import com.frontanilla.necromance.utils.helpers.Find;
import com.frontanilla.necromance.zones.game.GameStuff;

public class LatencyHelper {

    // Structure
    private GameStuff gameStuff;
    // Logic
    private float movePlayerTime;
    private boolean movePlayerTimeStarted;

    public void initializeStructure(GameStuff gameStuff) {
        this.gameStuff = gameStuff;
    }

    public void initState() {
        movePlayerTime = 0;
        movePlayerTimeStarted = false;
    }

    public void update(float delta) {
        if (movePlayerTimeStarted) {
            movePlayerTime += delta;
            if (movePlayerTime >= 1f) {
                Human thisHuman = Find.humanWithPhoneID(gameStuff.getHumanPlayers());
                thisHuman.setUseOriginalColor(false);
            }
        }
    }

    public void onMovePlayerStartTime() {
        movePlayerTime = 0;
        movePlayerTimeStarted = true;
    }

    public void onMovePlayerStopTime() {
        movePlayerTime = 0;
        movePlayerTimeStarted = false;
    }
}
