package com.frontanilla.necromance.desktop;

import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.frontanilla.necromance.database.clone.DBPlayerDocument;
import com.frontanilla.necromance.interfacing.firebase.RealtimeDBInterface;
import com.frontanilla.necromance.utils.advanced.ChangeListener;
import com.frontanilla.necromance.utils.advanced.OnResultListener;

public class DesktopRealtimeDB implements RealtimeDBInterface {

    @Override
    public void fetchVersionInRealtime(ChangeListener<String> listener) {
        listener.onDataFetched("0.0.2");
    }

    @Override
    public void fetchPlayerDataInRealtime(ChangeListener<DelayedRemovalArray<DBPlayerDocument>> listener) {

    }

    @Override
    public void stopFetchingPlayerDataInRealtime() {

    }

    @Override
    public void addPlayer(String playerID, OnResultListener onResultListener) {

    }

    @Override
    public void movePlayer(DBPlayerDocument thisPlayer, int x, int y, OnResultListener onResultListener) {

    }

    @Override
    public void changePlayerName(DBPlayerDocument thisPlayer, String chosenName, OnResultListener onResultListener) {

    }

    @Override
    public void changePlayerColor(DBPlayerDocument thisPlayer, String chosenColor, OnResultListener onResultListener) {

    }

    @Override
    public void changePlayerNameAndColor(DBPlayerDocument thisPlayer, String chosenName, String chosenColor, OnResultListener onResultListener) {

    }
}