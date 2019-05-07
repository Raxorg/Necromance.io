package com.frontanilla.necromance.database.subscribers;

import com.frontanilla.necromance.database.clone.DBPlayerDocument;

public abstract class DBPlayerSubscriber {

    public abstract void onUpdate(DBPlayerDocument databasePlayer);
}
