package com.frontanilla.necromance.database.clone;

public class DBPlayer {

    private String playerID;
    private String name;
    private int x, y;
    private String color;

    public DBPlayer(String playerID, String name, int x, int y, String color) {
        this.playerID = playerID;
        this.name = name;
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public String getPlayerID() {
        return playerID;
    }

    public String getName() {
        return name;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getColor() {
        return color;
    }

    public void update(DBPlayer databasePlayer) {
        if (playerID.equals(databasePlayer.playerID)) {
            name = databasePlayer.name;
            x = databasePlayer.x;
            y = databasePlayer.y;
            color = databasePlayer.color;
        } else {
            System.out.println("ATTEMPTING TO UPDATE DB PLAYER WITH ANOTHER DB PLAYER'S PLAYER ID");
        }
    }

    @Override
    public String toString() {
        return playerID + ": " + name + " " + x + "x " + y + "y " + color;
    }
}
