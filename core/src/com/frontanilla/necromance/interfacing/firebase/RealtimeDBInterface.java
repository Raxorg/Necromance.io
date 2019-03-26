package com.frontanilla.necromance.interfacing.firebase;

import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.frontanilla.necromance.database.clone.DBPlayer;
import com.frontanilla.necromance.utils.advanced.OnResultListener;
import com.frontanilla.necromance.utils.advanced.RealtimeChangeListener;
import com.frontanilla.necromance.utils.advanced.TimerListener;

public interface RealtimeDBInterface {

    void fetchPlayerDataInRealtime(RealtimeChangeListener<DelayedRemovalArray<DBPlayer>> listener);

    void stopFetchingPlayerDataInRealtime();

    void addPlayer(String playerID, OnResultListener listener);

    void movePlayer(String phoneID, int x, int y, OnResultListener onResultListener, TimerListener timerListener);
}
