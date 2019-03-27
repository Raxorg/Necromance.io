package com.frontanilla.necromance.zones.shared;

public class SharedLogic {

    // Firebase Logic
    private boolean movingPlayer, changingName, changingColor;

    public void initState() {
        movingPlayer = false;
        changingName = false;
        changingColor = false;
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

    public boolean isChangingColor() {
        return changingColor;
    }

    public void setChangingColor(boolean changingColor) {
        this.changingColor = changingColor;
    }
}
