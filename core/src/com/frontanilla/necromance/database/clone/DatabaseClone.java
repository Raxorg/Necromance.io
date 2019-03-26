package com.frontanilla.necromance.database.clone;

import com.badlogic.gdx.utils.DelayedRemovalArray;

public class DatabaseClone {

    private DBPlayerData databasePlayerData;

    public DatabaseClone() {
        databasePlayerData = new DBPlayerData();
    }

    //----------
    // Updating
    //----------
    public void updatePlayerData(DelayedRemovalArray<DBPlayer> players) {
        databasePlayerData.updatePlayerData(players);
    }

    // Advanced Getters
    public DelayedRemovalArray<DBPlayer> getPlayers() {
        return databasePlayerData.getDatabasePlayers();
    }
}
