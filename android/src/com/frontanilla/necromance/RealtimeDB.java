package com.frontanilla.necromance;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.badlogic.gdx.utils.DelayedRemovalArray;
import com.frontanilla.necromance.database.clone.DBPlayer;
import com.frontanilla.necromance.interfacing.firebase.RealtimeDBInterface;
import com.frontanilla.necromance.utils.advanced.OnResultListener;
import com.frontanilla.necromance.utils.advanced.RealtimeChangeListener;
import com.google.firebase.database.*;

public class RealtimeDB implements RealtimeDBInterface {

    private DatabaseReference playerDataReference;
    private ValueEventListener playerDataEventListener;

    RealtimeDB() {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        database.setPersistenceEnabled(false);
        playerDataReference = database.getReference("playerData");
    }

    //-------------------
    // Realtime Fetching
    //-------------------
    @Override
    public void fetchPlayerDataInRealtime(final RealtimeChangeListener<DelayedRemovalArray<DBPlayer>> listener) {
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
                            Integer.parseInt(parts[0]), // X
                            Integer.parseInt(parts[1])) // Y
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

    //-----------------
    // Player Addition
    //-----------------
    @Override
    public void addPlayer(String playerID, final OnResultListener listener) {
        playerDataReference.child(playerID).setValue("0,0", new DatabaseReference.CompletionListener() {
            @Override
            public void onComplete(@Nullable DatabaseError databaseError, @NonNull DatabaseReference databaseReference) {
                if (databaseError != null) {
                    listener.onResult(false);
                } else {
                    listener.onResult(true);
                }
            }
        });
    }

    //---------------
    // Player Moving
    //---------------
    @Override
    public void movePlayer(String phoneID, int x, int y, final OnResultListener onResultListener) {
        playerDataReference.child(phoneID).setValue(x + "," + y, new DatabaseReference.CompletionListener() {
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
}