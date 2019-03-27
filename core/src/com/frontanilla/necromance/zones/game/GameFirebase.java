package com.frontanilla.necromance.zones.game;

import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.frontanilla.necromance.database.clone.DBPlayer;
import com.frontanilla.necromance.utils.advanced.OnResultListener;
import com.frontanilla.necromance.utils.advanced.RealtimeChangeListener;
import com.frontanilla.necromance.utils.advanced.TimerListener;
import com.frontanilla.necromance.zones.foundations.ZoneFirebase;
import com.frontanilla.necromance.zones.game.logic.GameLogic;
import com.frontanilla.necromance.zones.shared.SharedFirebase;

public class GameFirebase extends ZoneFirebase {

    // Structure
    private GameLogic gameLogic;

    public void initializeStructure(GameLogic gameLogic) {
        this.gameLogic = gameLogic;
    }

    public GameFirebase(SharedFirebase sharedFirebase) {
        super(sharedFirebase);
    }

    //-------------------
    // Realtime Fetching
    //-------------------
    public void fetchPlayersInRealtime() {
        sharedFirebase.fetchPlayersInRealtime(new RealtimeChangeListener<DelayedRemovalArray<DBPlayer>>() {
            @Override
            public void onCancelled(String message) {
                System.out.println("Cancelled: " + message);
            }

            @Override
            public void onDataFetched(DelayedRemovalArray<DBPlayer> players) {
                System.out.println("Data Fetched:");
                for (DBPlayer player : players) {
                    System.out.print(player + ", ");
                }
                System.out.println();
                gameLogic.onPlayersFetched(players);
            }
        });
    }

    public void addPlayer() {
        sharedFirebase.addPlayer(new OnResultListener() {
            @Override
            public void onResult(boolean success) {
                System.out.println("Success Adding Player: " + success);
            }
        });
    }

    public void movePlayer(int x, int y) {
        sharedFirebase.movePlayer(x, y, new OnResultListener() {
            @Override
            public void onResult(boolean success) {
                System.out.println("Success Moving Player: " + success);
            }
        }, new TimerListener() {
            @Override
            public void startTime() {
                gameLogic.onMovePlayerStartTime();
            }

            @Override
            public void stopTime() {
                gameLogic.onMovePlayerStopTime();
            }
        });
    }

    public void changePlayerName(String chosenName) {
        sharedFirebase.changePlayerName(chosenName);
    }
}
