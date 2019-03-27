package com.frontanilla.necromance.database.subscribers;

import com.frontanilla.necromance.database.clone.DBPlayer;

public abstract class DBPlayerSubscriber {

    public abstract void onUpdate(DBPlayer databasePlayer);
}
