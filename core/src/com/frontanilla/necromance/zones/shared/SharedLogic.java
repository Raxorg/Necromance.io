package com.frontanilla.necromance.zones.shared;

public class SharedLogic {

    // Firebase Logic
    private boolean movingPlayer;

    public void initState() {
        movingPlayer = false;
    }

    public boolean isMovingPlayer() {
        return movingPlayer;
    }

    public void setMovingPlayer(boolean movingPlayer) {
        this.movingPlayer = movingPlayer;
    }
}
