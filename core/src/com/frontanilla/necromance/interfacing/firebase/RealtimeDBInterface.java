package com.frontanilla.necromance.interfacing.firebase;

import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.frontanilla.necromance.database.clone.DBPlayer;
import com.frontanilla.necromance.utils.advanced.ChangeListener;
import com.frontanilla.necromance.utils.advanced.OnResultListener;

public interface RealtimeDBInterface {

    void fetchVersionInRealtime(ChangeListener<String> listener);

    void fetchPlayerDataInRealtime(ChangeListener<DelayedRemovalArray<DBPlayer>> listener);

    void stopFetchingPlayerDataInRealtime();

    void addPlayer(String playerID, OnResultListener onResultListener);

    void movePlayer(DBPlayer thisPlayer, int x, int y, OnResultListener onResultListener);

    void changePlayerName(DBPlayer thisPlayer, String chosenName, OnResultListener onResultListener);

    void changePlayerColor(DBPlayer thisPlayer, String chosenColor, OnResultListener onResultListener);

    void changePlayerNameAndColor(DBPlayer thisPlayer, String chosenName, String chosenColor, OnResultListener onResultListener);
}
