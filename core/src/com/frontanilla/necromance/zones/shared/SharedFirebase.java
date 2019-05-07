package com.frontanilla.necromance.zones.shared;

import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.frontanilla.necromance.core.NecromanceClient;
import com.frontanilla.necromance.database.clone.DBPlayerDocument;
import com.frontanilla.necromance.utils.advanced.ChangeListener;
import com.frontanilla.necromance.utils.advanced.OnResultListener;
import com.frontanilla.necromance.utils.advanced.TimerListener;
import com.frontanilla.necromance.utils.helpers.Find;

public class SharedFirebase {

    // Structure
    private SharedLogic sharedLogic;
    private SharedStuff sharedStuff;

    public void initializeStructure(SharedLogic sharedLogic, SharedStuff sharedStuff) {
        this.sharedLogic = sharedLogic;
        this.sharedStuff = sharedStuff;
    }

    //-------------------
    // Realtime Fetching
    //-------------------
    // Version
    public void fetchVersionInRealtime(final ChangeListener<String> listener) {
        NecromanceClient.instance.getRealtimeDBInterface().fetchVersionInRealtime(new ChangeListener<String>() {
            @Override
            public void onCancelled(String message) {
                System.out.println("CANCELLED: " + message);
            }

            @Override
            public void onDataFetched(String version) {
                sharedStuff.getDatabaseClone().updateVersion(version);
                listener.onDataFetched(version);
            }
        });
    }

    // Players
    public void fetchPlayersInRealtime(final ChangeListener<DelayedRemovalArray<DBPlayerDocument>> listener) {
        NecromanceClient.instance.getRealtimeDBInterface().fetchPlayerDataInRealtime(
                new ChangeListener<DelayedRemovalArray<DBPlayerDocument>>() {
                    @Override
                    public void onCancelled(String message) {
                        System.out.println("CANCELLED: " + message);
                    }

                    @Override
                    public void onDataFetched(DelayedRemovalArray<DBPlayerDocument> players) {
                        sharedStuff.getDatabaseClone().updatePlayerData(players);
                        listener.onDataFetched(players);
                    }
                });
    }

    public void stopFetchingPlayersInRealtime() {
        NecromanceClient.instance.getRealtimeDBInterface().stopFetchingPlayerDataInRealtime();
    }

    //---------------
    // Player Adding
    //---------------
    public void addPlayer(OnResultListener listener) {
        NecromanceClient.instance.getRealtimeDBInterface().addPlayer(NecromanceClient.instance.getPhoneID(), listener);
    }

    //---------------
    // Player Moving
    //---------------
    public void movePlayer(int x, int y, final OnResultListener onResultListener, final TimerListener timerListener) {
        if (!sharedLogic.isMovingPlayer()) {
            sharedLogic.setMovingPlayer(true);
            timerListener.startTime();
            DBPlayerDocument thisPlayer = Find.databasePlayerWithPhoneID(sharedStuff.getDatabaseClone().getPlayers());
            NecromanceClient.instance.getRealtimeDBInterface().movePlayer(thisPlayer, x, y, new OnResultListener() {
                @Override
                public void onResult(boolean success) {
                    sharedLogic.setMovingPlayer(false);
                    timerListener.stopTime();
                    onResultListener.onResult(success);
                }
            });
        } else {
            System.out.println("THE PLAYER IS BEING MOVED, PLEASE WAIT");
        }
    }

    //----------------------
    // Player Name Changing
    //----------------------
    public void changePlayerName(String chosenName) {
        if (!sharedLogic.isChangingName()) {
            sharedLogic.setChangingName(true);
            DBPlayerDocument thisPlayer = Find.databasePlayerWithPhoneID(sharedStuff.getDatabaseClone().getPlayers());
            NecromanceClient.instance.getRealtimeDBInterface().changePlayerName(thisPlayer, chosenName, new OnResultListener() {
                @Override
                public void onResult(boolean success) {
                    sharedLogic.setChangingName(false);
                }
            });
        } else {
            System.out.println("THE PLAYER NAME IS BEING CHANGED, PLEASE WAIT");
        }
    }

    public void changePlayerColor(String chosenColor) {
        if (!sharedLogic.isChangingColor()) {
            sharedLogic.setChangingColor(true);
            DBPlayerDocument thisPlayer = Find.databasePlayerWithPhoneID(sharedStuff.getDatabaseClone().getPlayers());
            NecromanceClient.instance.getRealtimeDBInterface().changePlayerColor(thisPlayer, chosenColor, new OnResultListener() {
                @Override
                public void onResult(boolean success) {
                    sharedLogic.setChangingColor(false);
                }
            });
        } else {
            System.out.println("THE PLAYER NAME IS BEING CHANGED, PLEASE WAIT");
        }
    }

    public void changePlayerNameAndColor(String chosenName, String chosenColor) {
        if (!sharedLogic.isChangingName() && !sharedLogic.isChangingColor()) {
            sharedLogic.setChangingName(true);
            sharedLogic.setChangingColor(true);
            DBPlayerDocument thisPlayer = Find.databasePlayerWithPhoneID(sharedStuff.getDatabaseClone().getPlayers());
            NecromanceClient.instance.getRealtimeDBInterface().changePlayerNameAndColor(thisPlayer, chosenName, chosenColor,
                    new OnResultListener() {
                        @Override
                        public void onResult(boolean success) {
                            sharedLogic.setChangingName(false);
                            sharedLogic.setChangingColor(false);
                        }
                    });
        } else {
            System.out.println("THE PLAYER NAME OR COLOR IS BEING CHANGED, PLEASE WAIT");
        }
    }
}
