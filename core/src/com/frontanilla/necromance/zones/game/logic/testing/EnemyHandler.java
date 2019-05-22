package com.frontanilla.necromance.zones.game.logic.testing;

import com.frontanilla.necromance.utils.advanced.OnResultListener;
import com.frontanilla.necromance.zones.game.GameFirebase;
import com.frontanilla.necromance.zones.game.GameNetworked;

public class EnemyHandler {

    private GameFirebase gameFirebase;
    private GameNetworked gameNetworked;

    public void initializeStructure(
            GameFirebase gameFirebase,
            GameNetworked gameNetworked) {
        this.gameFirebase = gameFirebase;
        this.gameNetworked = gameNetworked;
    }

    public void spawnEnemy() {
        gameFirebase.addTestPlayer("TEST", new OnResultListener() {
            @Override
            public void onResult(boolean success) {
                if (success) {
                    gameFirebase.moveTestPlayer("TEST", 1050, 1050);
                }
            }
        });
    }
}