package com.frontanilla.necromance.zones.game.logic.helpers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.frontanilla.necromance.database.representation.Human;
import com.frontanilla.necromance.utils.helpers.Find;
import com.frontanilla.necromance.utils.helpers.Validate;
import com.frontanilla.necromance.zones.game.GameFirebase;
import com.frontanilla.necromance.zones.game.stuff.GameStuff;

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
        if (humanPlayer.equals(Find.humanWithPhoneID(gameStuff.getHumanPlayers()))) {
            Gdx.input.getTextInput(new Input.TextInputListener() {
                @Override
                public void input(String userText) {
                    String chosenName = userText.substring(0, Math.min(userText.length(), 10));
                    String[] parts = chosenName.split(",");
                    if (parts.length > 1) {
                        if (Validate.colorString(parts[1])) {
                            gameFirebase.changePlayerNameAndColor(parts[0],parts[1]);
                        }
                    } else {
                        gameFirebase.changePlayerName(chosenName);
                    }
                }

                @Override
                public void canceled() {

                }
            }, "Player name", humanPlayer.getDatabasePlayer().getName(), "Unnamed Newbie");
        }
    }

    public void touchDownOnEmptySpace(int x, int y) {
        gameFirebase.movePlayer((int) (x - HUMAN_SIZE / 2), (int) (y - HUMAN_SIZE / 2));
    }
}
