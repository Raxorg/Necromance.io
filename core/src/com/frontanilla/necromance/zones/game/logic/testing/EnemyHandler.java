package com.frontanilla.necromance.zones.game.logic.testing;

import com.badlogic.gdx.math.MathUtils;
import com.frontanilla.necromance.utils.advanced.OnResultListener;
import com.frontanilla.necromance.zones.game.GameFirebase;
import com.frontanilla.necromance.zones.game.GameNetworked;

import static com.frontanilla.necromance.zones.game.GameConstants.ENEMY_MOVE_INTERVAL;

public class EnemyHandler {

    private GameFirebase gameFirebase;
    private GameNetworked gameNetworked;
    // Logic
    private float time;

    public void initializeStructure(
            GameFirebase gameFirebase,
            GameNetworked gameNetworked) {
        this.gameFirebase = gameFirebase;
        this.gameNetworked = gameNetworked;
    }

    public void update(float delta) {
        time += delta;
        if (time >= ENEMY_MOVE_INTERVAL) {
            for (int i = 0; i < gameNetworked.getHumanPlayers().size; i++) {
                if (!gameNetworked.getHumanPlayers().get(i).getDatabasePlayer().getPlayerID().startsWith("Test")) {
                    continue;
                }
                int randomX = MathUtils.random(1100, 1900);
                int randomY = MathUtils.random(1100, 1900);
                gameFirebase.moveTestPlayer("Test" + i, randomX, randomY);
            }
            time = 0;
        }
    }

    public void spawnEnemy() {
        String fakePhoneID = "Test";
        int ID = gameNetworked.getHumanPlayers().size;
        fakePhoneID += ID;
        final String finalFakePhoneID = fakePhoneID;
        gameFirebase.addTestPlayer(fakePhoneID, new OnResultListener() {
            @Override
            public void onResult(boolean success) {
                if (success) {
                    gameFirebase.moveTestPlayer(finalFakePhoneID, 1250, 1250);
                }
            }
        });
    }
}