package com.frontanilla.necromance.database.clone;

import com.badlogic.gdx.utils.DelayedRemovalArray;

public class DBPlayerData {

    private DelayedRemovalArray<DBPlayer> databasePlayers;

    public DBPlayerData() {
        databasePlayers = new DelayedRemovalArray<>();
    }

    public void updatePlayerData(DelayedRemovalArray<DBPlayer> databasePlayers) {
        DB:
        for (int i = 0; i < databasePlayers.size; i++) {
            String playerID = databasePlayers.get(i).getPlayerID();
            for (int j = 0; j < this.databasePlayers.size; j++) {
                DBPlayer existentPlayer = this.databasePlayers.get(j);
                if (existentPlayer.getPlayerID().equals(playerID)) {
                    existentPlayer.update(databasePlayers.get(i));
                    continue DB;
                }
            }
            this.databasePlayers.add(databasePlayers.get(i));
        }
    }

    public DelayedRemovalArray<DBPlayer> getDatabasePlayers() {
        return databasePlayers;
    }

}
