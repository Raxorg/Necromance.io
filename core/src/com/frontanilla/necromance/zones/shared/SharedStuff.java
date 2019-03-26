package com.frontanilla.necromance.zones.shared;

import com.frontanilla.necromance.database.clone.DatabaseClone;

public class SharedStuff {

    private DatabaseClone databaseClone;

    public void initStuff() {
        databaseClone = new DatabaseClone();
    }

    public DatabaseClone getDatabaseClone() {
        return databaseClone;
    }
}
