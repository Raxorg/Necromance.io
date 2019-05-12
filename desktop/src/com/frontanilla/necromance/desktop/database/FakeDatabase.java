package com.frontanilla.necromance.desktop.database;

import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.badlogic.gdx.utils.Timer;
import com.frontanilla.necromance.database.clone.DBPlayerDocument;
import com.frontanilla.necromance.utils.advanced.ChangeListener;
import com.frontanilla.necromance.utils.advanced.OnResultListener;

public class FakeDatabase {

    public static final float FAKE_RESPONSE_DELAY = 1f; // In seconds

    private String version;
    private DelayedRemovalArray<String> playerData;

    private ChangeListener<String> versionListener;
    private ChangeListener<DelayedRemovalArray<DBPlayerDocument>> playerDataListener;

    // Here we build a new Database with initial data for testing
    public FakeDatabase() {
        version = "0.0.2";
        playerData = new DelayedRemovalArray<>();
    }

    // Version
    public void addVersionListener(ChangeListener<String> listener) {
        versionListener = listener;
        versionListener.onDataFetched(version);
    }

    // TODO: Use for testing
    public void changeVersion(String newVersion) {
        version = newVersion;
        if (versionListener != null) {
            versionListener.onDataFetched(version);
        }
    }


    // Player Data
    public void addPlayerDataListener(ChangeListener<DelayedRemovalArray<DBPlayerDocument>> listener) {
        playerDataListener = listener;
        playerDataListener.onDataFetched(buildPlayerDocumentArray());
    }

    public void removePlayerDataListener() {
        playerDataListener = null;
    }

    public void setPlayer(String value, OnResultListener onResultListener) {
        int existentPlayerIndex = -1;
        String incomingPlayerID = value.split(",")[0];
        for (int i = 0; i < playerData.size; i++) {
            String storedPlayerID = playerData.get(i).split(",")[0];
            if (storedPlayerID.equals(incomingPlayerID)) {
                existentPlayerIndex = i;
                break;
            }
        }
        if (existentPlayerIndex != -1) {
            playerData.set(existentPlayerIndex, value);
        } else {
            addPlayerDocument(value);
        }
        Timer.schedule(new Timer.Task() {
            @Override
            public void run() {
                onResultListener.onResult(true);
                if (playerDataListener != null) {
                    playerDataListener.onDataFetched(buildPlayerDocumentArray());
                }
            }
        }, FAKE_RESPONSE_DELAY);
    }

    private void addPlayerDocument(String value) {
        playerData.add(value);
    }

    private DelayedRemovalArray<DBPlayerDocument> buildPlayerDocumentArray() {
        DelayedRemovalArray<DBPlayerDocument> playerDocuments = new DelayedRemovalArray<>();
        for (int i = 0; i < playerData.size; i++) {
            String[] parts = playerData.get(i).split(",");
            String playerID = parts[0];
            String name = parts[1];
            int x = Integer.parseInt(parts[2]);
            int y = Integer.parseInt(parts[3]);
            String color = parts[4];
            DBPlayerDocument playerDocument = new DBPlayerDocument(playerID, name, x, y, color);
            playerDocuments.add(playerDocument);
        }
        return playerDocuments;
    }
}