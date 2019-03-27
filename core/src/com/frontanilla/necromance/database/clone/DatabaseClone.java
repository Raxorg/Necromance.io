package com.frontanilla.necromance.database.clone;

import com.badlogic.gdx.utils.DelayedRemovalArray;

public class DatabaseClone {

    private DBVersion databaseVersion;
    private DBPlayerData databasePlayerData;

    public DatabaseClone() {
        databaseVersion = new DBVersion();
        databasePlayerData = new DBPlayerData();
    }

    //----------
    // Updating
    //----------
    public void updateVersion(String version) {
        databaseVersion.updateVersion(version);
    }

    public void updatePlayerData(DelayedRemovalArray<DBPlayer> players) {
        databasePlayerData.updatePlayerData(players);
    }

    // Advanced Getters
    public DelayedRemovalArray<DBPlayer> getPlayers() {
        return databasePlayerData.getDatabasePlayers();
    }
}
