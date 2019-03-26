package com.frontanilla.necromance.zones.shared;

import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.frontanilla.necromance.core.NecromanceClient;
import com.frontanilla.necromance.database.clone.DBPlayer;
import com.frontanilla.necromance.utils.advanced.OnResultListener;
import com.frontanilla.necromance.utils.advanced.RealtimeChangeListener;
import com.frontanilla.necromance.utils.advanced.TimerListener;

public class SharedFirebase {

    private SharedStuff sharedStuff;

    public void initializeStructure(SharedStuff sharedStuff) {
        this.sharedStuff = sharedStuff;
    }

    //-------------------
    // Realtime Fetching
    //-------------------
    public void fetchPlayersInRealtime(final RealtimeChangeListener<DelayedRemovalArray<DBPlayer>> listener) {
        NecromanceClient.instance.getRealtimeDBInterface().fetchPlayerDataInRealtime(
                new RealtimeChangeListener<DelayedRemovalArray<DBPlayer>>() {
                    @Override
                    public void onCancelled(String message) {
                        System.out.println(message);
                    }

                    @Override
                    public void onDataFetched(DelayedRemovalArray<DBPlayer> players) {
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

    public void movePlayer(int x, int y, OnResultListener onResultListener, TimerListener timerListener) {
        String phoneID = NecromanceClient.instance.getPhoneID();
        NecromanceClient.instance.getRealtimeDBInterface().movePlayer(phoneID, x, y, onResultListener, timerListener);
    }
}
