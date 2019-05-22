package com.frontanilla.necromance.zones.game.logic.helpers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Pixmap;
import com.frontanilla.necromance.core.NecromanceClient;
import com.frontanilla.necromance.database.clone.DBPlayerDocument;
import com.frontanilla.necromance.database.representation.Human;
import com.frontanilla.necromance.utils.advanced.DataListener;
import com.frontanilla.necromance.utils.helpers.Find;
import com.frontanilla.necromance.utils.helpers.Validate;
import com.frontanilla.necromance.zones.game.GameFirebase;
import com.frontanilla.necromance.zones.game.GameNetworked;
import com.frontanilla.necromance.zones.game.logic.GameLogic;
import com.frontanilla.necromance.zones.game.stuff.GameStuff;

import static com.frontanilla.necromance.zones.game.GameConstants.HUMAN_SIZE;

public class ProcessedInputHandler {

    // Structure
    private GameFirebase gameFirebase;
    private GameLogic gameLogic;
    private GameNetworked gameNetworked;
    private GameStuff gameStuff;
    // Logic


    public void initializeStructure(
            GameFirebase gameFirebase,
            GameLogic gameLogic,
            GameNetworked gameNetworked,
            GameStuff gameStuff) {
        this.gameFirebase = gameFirebase;
        this.gameLogic = gameLogic;
        this.gameNetworked = gameNetworked;
        this.gameStuff = gameStuff;
    }

    public void initState() {
        // TODO
    }

    public void touchDownOnHumanPlayer(Human humanPlayer) {
        if (humanPlayer.equals(Find.humanWithPhoneID(gameNetworked.getHumanPlayers()))) {
            Gdx.input.getTextInput(new Input.TextInputListener() {
                @Override
                public void input(String userText) {
                    String chosenName = userText.substring(0, Math.min(userText.length(), 10));
                    String[] parts = chosenName.split(",");
                    if (parts.length > 1) {
                        if (Validate.colorString(parts[1])) {
                            gameFirebase.changePlayerNameAndColor(parts[0], parts[1]);
                        }
                    } else {
                        gameFirebase.changePlayerName(chosenName);
                    }
                }

                @Override
                public void canceled() {
                    // TODO
                }
            }, "Player name", humanPlayer.getDatabasePlayer().getName(), "");
        } else {
            NecromanceClient.instance.getAuthInterface().touchUpOnSignInButton(new DataListener<String>() {
                @Override
                public void onData(String googleAccountDisplayName) {
                    System.out.println(googleAccountDisplayName);
                }
            }, new DataListener<int[][]>() {
                @Override
                public void onData(final int[][] imageData) {
                    Gdx.app.postRunnable(new Runnable() {
                        @Override
                        public void run() {
                            Pixmap pixmap = new Pixmap(imageData[0].length, imageData.length, Pixmap.Format.RGBA8888);
                            for (int row = 0; row < imageData.length; row++) {
                                for (int column = 0; column < imageData[row].length; column++) {
                                    int argb = imageData[row][column];
                                    int rgba = (argb << 8) | (argb >>> (32 - 8));
                                    pixmap.drawPixel(column, row, rgba);
                                    pixmap.drawPixel(15, 15, argb);
                                    pixmap.drawPixel(5, 5, rgba);
                                }
                            }
                            gameStuff.assignTexture(pixmap); // TODO: TEST
                        }
                    });
                }
            });
        }
    }

    public void touchDownOnEmptySpace(int x, int y) {
        DBPlayerDocument thisPlayer = Find.databasePlayerWithThisPhoneID(gameStuff.getSharedStuff().getDatabaseClone().getPlayers());
        if (thisPlayer != null) {
            gameFirebase.movePlayer((int) (x - HUMAN_SIZE / 2), (int) (y - HUMAN_SIZE / 2));
        } else {
            gameLogic.getMessageHandler().addMessage("You have not spawned yet");
        }
    }

    public void spaceKeyUp() {
        gameLogic.getEnemyHandler().spawnEnemy();
    }
}