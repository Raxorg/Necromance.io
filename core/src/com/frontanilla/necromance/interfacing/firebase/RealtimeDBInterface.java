package com.frontanilla.necromance.interfacing.firebase;

import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.frontanilla.necromance.database.clone.DBPlayerDocument;
import com.frontanilla.necromance.utils.advanced.ChangeListener;
import com.frontanilla.necromance.utils.advanced.OnResultListener;

public interface RealtimeDBInterface {

    void fetchVersionInRealtime(ChangeListener<String> listener);

    void fetchPlayerDataInRealtime(ChangeListener<DelayedRemovalArray<DBPlayerDocument>> listener);

    void stopFetchingPlayerDataInRealtime();

    void addPlayer(String playerID, OnResultListener onResultListener);

    void movePlayer(DBPlayerDocument thisPlayer, int x, int y, OnResultListener onResultListener);

    void changePlayerName(DBPlayerDocument thisPlayer, String chosenName, OnResultListener onResultListener);

    void changePlayerColor(DBPlayerDocument thisPlayer, String chosenColor, OnResultListener onResultListener);

    void changePlayerNameAndColor(DBPlayerDocument thisPlayer, String chosenName, String chosenColor, OnResultListener onResultListener);
}
