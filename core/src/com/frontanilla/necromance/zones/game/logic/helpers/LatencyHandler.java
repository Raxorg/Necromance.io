package com.frontanilla.necromance.zones.game.logic.helpers;

import com.frontanilla.necromance.database.representation.Human;
import com.frontanilla.necromance.utils.helpers.Find;
import com.frontanilla.necromance.zones.game.GameNetworked;
import com.frontanilla.necromance.zones.game.stuff.GameStuff;

import static com.frontanilla.necromance.zones.game.GameConstants.MAX_ALLOWED_DELAY;

public class LatencyHandler {

    // Structure
    private GameNetworked gameNetworked;
    // Logic
    private float movePlayerTime;
    private boolean movePlayerTimeStarted;

    public void initializeStructure(GameNetworked gameNetworked) {
        this.gameNetworked = gameNetworked;
    }

    public void initState() {
        movePlayerTime = 0;
        movePlayerTimeStarted = false;
    }

    public void update(float delta) {
        if (movePlayerTimeStarted) {
            movePlayerTime += delta;
            if (movePlayerTime >= MAX_ALLOWED_DELAY) {
                Human thisHuman = Find.humanWithPhoneID(gameNetworked.getHumanPlayers());
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
        Human thisHuman = Find.humanWithPhoneID(gameNetworked.getHumanPlayers());
        thisHuman.setUseOriginalColor(true);
    }
}