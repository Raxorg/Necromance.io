package com.frontanilla.necromance.database.clone;

public class DBPlayer {

    private String playerID;
    private int x, y;

    public DBPlayer(String playerID, int x, int y) {
        this.playerID = playerID;
        this.x = x;
        this.y = y;
    }

    public String getPlayerID() {
        return playerID;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void update(DBPlayer databasePlayer) {
        if (playerID.equals(databasePlayer.playerID)) {
            x = databasePlayer.x;
            y = databasePlayer.y;
        } else {
            System.out.println("ATTEMPTING TO UPDATE DB PLAYER WITH ANOTHER DB PLAYER'S PLAYER ID");
        }
    }

    @Override
    public String toString() {
        return playerID + ": " + x + "x " + y + "y";
    }
}
