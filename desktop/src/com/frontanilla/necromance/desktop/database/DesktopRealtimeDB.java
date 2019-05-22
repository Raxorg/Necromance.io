package com.frontanilla.necromance.desktop.database;

import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.frontanilla.necromance.database.clone.DBPlayerDocument;
import com.frontanilla.necromance.interfacing.firebase.RealtimeDBInterface;
import com.frontanilla.necromance.utils.advanced.ChangeListener;
import com.frontanilla.necromance.utils.advanced.OnResultListener;

public class DesktopRealtimeDB implements RealtimeDBInterface {

    private FakeDatabase fakeDatabase;

    public DesktopRealtimeDB() {
        fakeDatabase = new FakeDatabase();
    }

    @Override
    public void fetchVersionInRealtime(ChangeListener<String> listener) {
        fakeDatabase.addVersionListener(listener);
    }

    @Override
    public void fetchPlayerDataInRealtime(ChangeListener<DelayedRemovalArray<DBPlayerDocument>> listener) {
        fakeDatabase.addPlayerDataListener(listener);
    }

    @Override
    public void stopFetchingPlayerDataInRealtime() {
        fakeDatabase.removePlayerDataListener();
    }

    @Override
    public void addPlayer(String playerID, OnResultListener onResultListener) {
        fakeDatabase.setPlayer(playerID + ",Bob,0,0,R", onResultListener);
    }

    @Override
    public void movePlayer(DBPlayerDocument playerDocument, int x, int y, OnResultListener onResultListener) {
        String newValue = playerDocument.getPlayerID() + "," +
                playerDocument.getName() + "," +
                x + "," +
                y + "," +
                playerDocument.getColor();
        fakeDatabase.setPlayer(newValue, onResultListener);
    }

    @Override
    public void changePlayerName(DBPlayerDocument thisPlayer, String chosenName, OnResultListener onResultListener) {
        String newValue = thisPlayer.getPlayerID() + "," +
                chosenName + "," +
                thisPlayer.getX() + "," + thisPlayer.getY() + "," +
                thisPlayer.getColor();
        fakeDatabase.setPlayer(newValue, onResultListener);
    }

    @Override
    public void changePlayerColor(DBPlayerDocument thisPlayer, String chosenColor, OnResultListener onResultListener) {
        String newValue = thisPlayer.getPlayerID() + "," +
                thisPlayer.getName() + "," +
                thisPlayer.getX() + "," +
                thisPlayer.getY() + "," +
                chosenColor;
        fakeDatabase.setPlayer(newValue, onResultListener);
    }

    @Override
    public void changePlayerNameAndColor(DBPlayerDocument thisPlayer, String chosenName, String chosenColor, OnResultListener onResultListener) {
        String newValue = thisPlayer.getPlayerID() + "," +
                chosenName + "," +
                thisPlayer.getX() + "," +
                thisPlayer.getY() + "," +
                chosenColor;
        fakeDatabase.setPlayer(newValue, onResultListener);
    }
}