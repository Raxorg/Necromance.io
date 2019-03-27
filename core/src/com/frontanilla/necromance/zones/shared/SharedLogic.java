package com.frontanilla.necromance.zones.shared;

public class SharedLogic {

    // Firebase Logic
    private boolean movingPlayer;
    private boolean changingName;

    public void initState() {
        movingPlayer = false;
        changingName = false;
    }

    public boolean isMovingPlayer() {
        return movingPlayer;
    }

    public void setMovingPlayer(boolean movingPlayer) {
        this.movingPlayer = movingPlayer;
    }

    public boolean isChangingName() {
        return changingName;
    }

    public void setChangingName(boolean changingName) {
        this.changingName = changingName;
    }
}
