package com.frontanilla.necromance.zones.game.logic.helpers;

import com.badlogic.gdx.graphics.Color;
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
                Find.humanWithPhoneID(gameStuff.getHumanPlayers()).setColor(Color.WHITE.cpy().lerp(Color.CLEAR, 0.5f));
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
