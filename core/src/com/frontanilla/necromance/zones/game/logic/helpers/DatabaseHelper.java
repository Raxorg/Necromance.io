package com.frontanilla.necromance.zones.game.logic.helpers;

import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.frontanilla.necromance.core.NecromanceClient;
import com.frontanilla.necromance.database.clone.DBPlayer;
import com.frontanilla.necromance.database.representation.Human;
import com.frontanilla.necromance.utils.helpers.Find;
import com.frontanilla.necromance.zones.game.GameAssets;
import com.frontanilla.necromance.zones.game.GameFirebase;
import com.frontanilla.necromance.zones.game.GameInput;
import com.frontanilla.necromance.zones.game.GameStuff;
import com.frontanilla.necromance.zones.game.logic.GameLogic;

public class DatabaseHelper {

    // Structure
    private GameAssets gameAssets;
    private GameFirebase gameFirebase;
    private GameInput gameInput;
    private GameLogic gameLogic;
    private GameStuff gameStuff;
    // Logic
    private boolean initialPlayersFetched;

    public void initializeStructure(GameAssets gameAssets, GameFirebase gameFirebase, GameInput gameInput, GameLogic gameLogic,
                                    GameStuff gameStuff) {
        this.gameAssets = gameAssets;
        this.gameFirebase = gameFirebase;
        this.gameInput = gameInput;
        this.gameLogic = gameLogic;
        this.gameStuff = gameStuff;
    }

    public void initState() {
        initialPlayersFetched = false;
        gameFirebase.fetchPlayersInRealtime();
    }


    public void onPlayersFetched(DelayedRemovalArray<DBPlayer> databasePlayers) {
        // Enable Input at the First Time Receiving PLayers
        if (!initialPlayersFetched) {
            gameInput.setEnabled(true);
            initialPlayersFetched = true;
        }
        // Add or Update Fetched Players
        DB:
        for (int i = 0; i < databasePlayers.size; i++) {
            String databasePlayerID = databasePlayers.get(i).getPlayerID();
            for (int j = 0; j < gameStuff.getHumanPlayers().size; j++) {
                String existentPlayerID = gameStuff.getHumanPlayers().get(j).getDatabasePlayer().getPlayerID();
                if (existentPlayerID.equals(databasePlayerID)) {
                    continue DB;
                }
            }
            Human newHuman = new Human(databasePlayers.get(i));
            newHuman.setTextureRegion(gameAssets.getHuman());
            newHuman.setFont(gameAssets.getTimesSquare());
            gameStuff.getHumanPlayers().add(newHuman);
        }
        // Add to Database or Restore Color of This Player
        Human thisPlayer = Find.humanWithPhoneID(gameStuff.getHumanPlayers());
        if (thisPlayer == null) {
            // This Player is not in the Database, Add it
            gameFirebase.addPlayer();
        } else {
            // This Player is in the Database, Restore its Color
            if (gameLogic.getSharedLogic().isMovingPlayer()) {
                thisPlayer.setUseOriginalColor(true);
            }
        }
    }
}
