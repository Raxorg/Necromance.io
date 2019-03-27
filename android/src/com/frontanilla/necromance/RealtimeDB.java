package com.frontanilla.necromance;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.frontanilla.necromance.database.clone.DBPlayer;
import com.frontanilla.necromance.interfacing.firebase.RealtimeDBInterface;
import com.frontanilla.necromance.utils.advanced.ChangeListener;
import com.frontanilla.necromance.utils.advanced.OnResultListener;
import com.google.firebase.database.*;

public class RealtimeDB implements RealtimeDBInterface {

    private DatabaseReference versionReference;
    private DatabaseReference playerDataReference;
    private ValueEventListener playerDataEventListener;

    RealtimeDB() {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        database.setPersistenceEnabled(false);
        versionReference = database.getReference("version");
        playerDataReference = database.getReference("playerData");
    }

    //-------------------
    // Realtime Fetching
    //-------------------
    // Version
    @Override
    public void fetchVersionInRealtime(final ChangeListener<String> listener) {
        versionReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                listener.onDataFetched(dataSnapshot.getValue(String.class));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                listener.onCancelled(databaseError.getMessage());
            }
        });
    }

    // Players
    @Override
    public void fetchPlayerDataInRealtime(final ChangeListener<DelayedRemovalArray<DBPlayer>> listener) {
        playerDataEventListener = playerDataReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                DelayedRemovalArray<DBPlayer> players = new DelayedRemovalArray<>();
                String playerSnapshotValue;
                String[] parts = new String[0];
                for (DataSnapshot playerSnapshot : dataSnapshot.getChildren()) {
                    playerSnapshotValue = playerSnapshot.getValue(String.class);
                    if (playerSnapshotValue != null) {
                        parts = playerSnapshotValue.split(",");
                    }
                    players.add(new DBPlayer(
                            playerSnapshot.getKey(),    // Player ID
                            parts[0],                   // Name
                            Integer.parseInt(parts[1]), // X
                            Integer.parseInt(parts[2]), // Y
                            parts[3])                   // Color
                    );
                }
                listener.onDataFetched(players);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                listener.onCancelled(databaseError.getMessage());
            }
        });
    }

    @Override
    public void stopFetchingPlayerDataInRealtime() {
        if (playerDataEventListener != null) {
            playerDataReference.removeEventListener(playerDataEventListener);
            System.out.println(playerDataEventListener == null);
        }
    }

    //----------------------
    // Player Field Setting
    //----------------------

    private void setPlayerReference(String playerID, String newReferenceValue, final OnResultListener onResultListener) {
        playerDataReference.child(playerID).setValue(newReferenceValue, new DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(@Nullable DatabaseError databaseError, @NonNull DatabaseReference databaseReference) {
                if (databaseError != null) {
                    onResultListener.onResult(false);
                } else {
                    onResultListener.onResult(true);
                }
            }
        });
    }

    //-----------------
    // Player Addition
    //-----------------
    @Override
    public void addPlayer(String playerID, final OnResultListener onResultListener) {
        String newReferenceValue = "Bob,0,0,R";
        setPlayerReference(playerID, newReferenceValue, onResultListener);
    }

    //---------------
    // Player Moving
    //---------------
    @Override
    public void movePlayer(DBPlayer thisPlayer, int x, int y, final OnResultListener onResultListener) {
        String newReferenceValue = thisPlayer.getName() + "," + x + "," + y + "," + thisPlayer.getColor();
        setPlayerReference(thisPlayer.getPlayerID(), newReferenceValue, onResultListener);
    }

    //----------------------
    // Player Name Changing
    //----------------------
    @Override
    public void changePlayerName(DBPlayer thisPlayer, String chosenName, final OnResultListener onResultListener) {
        String newReferenceValue = chosenName + "," + thisPlayer.getX() + "," + thisPlayer.getY() + "," + thisPlayer.getColor();
        setPlayerReference(thisPlayer.getPlayerID(), newReferenceValue, onResultListener);
    }

    //-----------------------
    // Player Color Changing
    //-----------------------
    @Override
    public void changePlayerColor(DBPlayer thisPlayer, String chosenColor, OnResultListener onResultListener) {
        String newReferenceValue = thisPlayer.getName() + "," + thisPlayer.getX() + "," + thisPlayer.getY() + "," + chosenColor;
        setPlayerReference(thisPlayer.getPlayerID(), newReferenceValue, onResultListener);
    }
}