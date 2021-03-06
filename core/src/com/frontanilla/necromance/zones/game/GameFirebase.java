package com.frontanilla.necromance.zones.game;

import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.frontanilla.necromance.database.clone.DBPlayerDocument;
import com.frontanilla.necromance.utils.advanced.ChangeListener;
import com.frontanilla.necromance.utils.advanced.OnResultListener;
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
        sharedFirebase.fetchPlayersInRealtime(new ChangeListener<DelayedRemovalArray<DBPlayerDocument>>() {
            @Override
            public void onCancelled(String message) {
                System.out.println("Cancelled: " + message);
            }

            @Override
            public void onDataFetched(DelayedRemovalArray<DBPlayerDocument> players) {
                System.out.println("Data Fetched:");
                for (DBPlayerDocument player : players) {
                    System.out.print(player + ", ");
                }
                System.out.println();
                gameLogic.getDatabaseHandler().onPlayersFetched(players);
            }
        });
    }

    public void addThisPlayer() {
        sharedFirebase.addThisPlayer(new OnResultListener() {
            @Override
            public void onResult(boolean success) {
                System.out.println("Success Adding Player: " + success);
            }
        });
    }

    public void addTestPlayer(String fakePhoneID, OnResultListener resultListener) {
        sharedFirebase.addTestPlayer(fakePhoneID, resultListener);
    }

    public void moveThisPlayer(int x, int y) {
        sharedFirebase.moveThisPlayer(x, y, new OnResultListener() {
            @Override
            public void onResult(boolean success) {
                System.out.println("Success Moving Player: " + success);
            }
        }, new TimerListener() {
            @Override
            public void startTime() {
                gameLogic.getLatencyHandler().onMovePlayerStartTime();
            }

            @Override
            public void stopTime() {
                gameLogic.getLatencyHandler().onMovePlayerStopTime();
            }
        });
    }

    public void moveTestPlayer(String fakePhoneID, int x, int y) {
        sharedFirebase.moveTestPlayer(fakePhoneID, x, y, new OnResultListener() {
            @Override
            public void onResult(boolean success) {
                System.out.println("Success moving test player: " + success);
            }
        });
    }

    public void changePlayerName(String chosenName) {
        sharedFirebase.changePlayerName(chosenName);
    }

    public void changePlayerColor(String chosenColor) {
        sharedFirebase.changePlayerColor(chosenColor);
    }

    public void changePlayerNameAndColor(String chosenName, String chosenColor) {
        sharedFirebase.changePlayerNameAndColor(chosenName, chosenColor);
    }
}