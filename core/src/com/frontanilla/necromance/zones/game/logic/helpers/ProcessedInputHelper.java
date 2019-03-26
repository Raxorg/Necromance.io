package com.frontanilla.necromance.zones.game.logic.helpers;

import com.badlogic.gdx.graphics.Color;
import com.frontanilla.necromance.database.representation.Human;
import com.frontanilla.necromance.zones.game.GameFirebase;
import com.frontanilla.necromance.zones.game.GameStuff;

import static com.frontanilla.necromance.zones.game.GameConstants.HUMAN_SIZE;

public class ProcessedInputHelper {

    // Structure
    private GameFirebase gameFirebase;
    private GameStuff gameStuff;
    // Logic


    public void initializeStructure(GameFirebase gameFirebase, GameStuff gameStuff) {
        this.gameFirebase = gameFirebase;
        this.gameStuff = gameStuff;
    }

    public void initState() {

    }

    public void touchDownOnHumanPlayer(Human humanPlayer) {
        if (humanPlayer.getColor() == Color.RED) {
            humanPlayer.setColor(Color.GREEN);
        } else {
            humanPlayer.setColor(Color.RED);
        }
    }

    public void touchDownOnEmptySpace(int x, int y) {
        gameFirebase.movePlayer((int) (x - HUMAN_SIZE / 2), (int) (y - HUMAN_SIZE / 2));
    }
}
